package com.atbs.booking;

import com.atbs.customer.Customer;
import com.atbs.customer.CustomerItem;
import com.atbs.flight.FlightItem;

public class BookingItem {
    private CustomerItem customer;
    private FlightItem flight;
    public CustomerItem getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerItem customer) {
        this.customer = customer;
    }

    public FlightItem getFlight() {
        return flight;
    }

    public void setFlight(FlightItem flight) {
        this.flight = flight;
    }
}
