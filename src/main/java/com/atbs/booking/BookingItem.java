package com.atbs.booking;

import com.atbs.customer.Customer;
import com.atbs.flight.FlightItem;

public class BookingItem {
    private Customer customer;
    private FlightItem flight;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
