package com.atbs.booking;

import com.atbs.base.BaseEntity;
import com.atbs.customer.Customer;
import com.atbs.flight.Flight;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {
    //flight
    //customer

    @JsonIgnore
    @OneToOne
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
