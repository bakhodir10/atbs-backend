package com.atbs.company;

import com.atbs.airport.Airport;
import com.atbs.base.BaseEntity;
import com.atbs.booking.Booking;
import com.atbs.companyAdminUser.CompanyAdminUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Airport> airports;

    @OneToMany(mappedBy = "company")
    private List<CompanyAdminUser> adminUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
