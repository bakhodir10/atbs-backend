package com.atbs.flight;

import com.atbs.airport.AirportItem;

import java.util.Date;

public class FlightItem {
    private Long id;
    private Date date;
    private String time;
    private double price;
    private AirportItem from;
    private AirportItem to;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrom(AirportItem from) {
        this.from = from;
    }

    public void setTo(AirportItem to) {
        this.to = to;
    }

    public AirportItem getFrom() {
        return from;
    }

    public AirportItem getTo() {
        return to;
    }

    public Flight getEntity(){
        Flight flight = new Flight();
        flight.setId(this.id);
        flight.setDate(this.date);
        flight.setTime(this.time);
        flight.setFrom(this.from.getEntity());
        flight.setTo(this.to.getEntity());
        flight.setPrice(this.price);

        return flight;
    }
}
