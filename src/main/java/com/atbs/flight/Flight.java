package com.atbs.flight;

import com.atbs.airport.Airport;
import org.hibernate.exception.DataException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {
    @Column(name = "date")
    @NotNull
    private Date date;

    //Airport from;
    //Airport to;

    @Column(name = "time")
    @NotNull
    private  String time;

    @Column(name = "price")
    @NotNull
    private double price;

    //Aeroplane
    //bookings
}
