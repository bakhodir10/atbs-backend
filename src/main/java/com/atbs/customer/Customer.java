package com.atbs.customer;

import com.atbs.base.BaseEntity;
import com.atbs.booking.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "dob")
    private Date dob;

    @JsonIgnore
    @OneToOne
    private Booking booking;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
