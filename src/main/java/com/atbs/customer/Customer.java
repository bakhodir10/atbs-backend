package com.atbs.customer;

import com.atbs.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    @NotNull
    @Column(name="full_name")
    private String fullName;

    @NotNull
    @Column(name="email")
    private  String email;

    @NotNull
    @Column(name = "dob")
    private Date dob;
}
