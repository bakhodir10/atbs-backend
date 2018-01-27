package com.atbs.flight;

import com.atbs.airport.Airport;
import com.atbs.base.BaseEntity;
import com.atbs.booking.Booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity {
    @Column(name = "date")
    @NotNull
    private Date date;
    @Column(name = "time")
    @NotNull
    private String time;
    @Column(name = "price")
    @NotNull
    private double price;

    //Airport from;
    //Airport to;
    @OneToOne
    private Airport from;
    @OneToOne
    private Airport to;

    //Aeroplane
    //bookings

   // @OneToMany(mappedBy = "flight")
    //private List<Booking> bookings;

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id")
    private Airport airport;*/

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

   /* public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }*/

  /*  public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }*/
}
