package com.atbs.booking;

import com.atbs.customer.Customer;
import com.atbs.flight.Flight;

public class BookingItem {
    private Customer customer;
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
