package com.atbs.airport;

import com.atbs.base.BaseEntity;
import com.atbs.company.Company;
import com.atbs.flight.Flight;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport extends BaseEntity {
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "airport")
    private List<Flight> flights;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
