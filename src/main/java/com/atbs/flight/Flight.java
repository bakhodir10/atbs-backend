package com.atbs.flight;

import com.atbs.airport.Airport;
import com.atbs.airport.AirportItem;
import com.atbs.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity {
    @Column(name = "date")
    @NotNull
    private Date date; // todo why do we need this, we already have time property below ???

    @Column(name = "time")
    @NotNull
    private String time;

    @Column(name = "price")
    @NotNull
    private double price;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id")
    private Airport from;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "to_id", referencedColumnName = "id")
    private Airport to;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
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

    public FlightItem getFlightItem() {
        FlightItem item = new FlightItem();
        item.setId(getId());
        item.setTime(this.time);
        item.setDate(this.date);
        item.setPrice(this.price);

        AirportItem from = new AirportItem();
        from.setId(this.from.getId());
        from.setName(this.from.getName());
        from.setLocation(this.from.getLocation());
        item.setFrom(from);

        AirportItem to = new AirportItem();
        to.setId(this.to.getId());
        to.setName(this.to.getName());
        to.setLocation(this.to.getLocation());
        item.setTo(to);

        return item;
    }
}
