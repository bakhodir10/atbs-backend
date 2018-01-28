package com.atbs.company;

import com.atbs.airport.Airport;
import com.atbs.base.BaseEntity;
import com.atbs.companyAdminUser.CompanyAdminUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "is_active", columnDefinition="boolean default false")
    private boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Airport> airports;

    @JsonIgnore
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<CompanyAdminUser> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(List<CompanyAdminUser> adminUsers) {
        this.adminUsers = adminUsers;
    }
}
