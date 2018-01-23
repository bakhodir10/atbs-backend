package com.atbs.airport;

import com.atbs.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "airport")
public class Airport extends BaseEntity {
    @NotNull
    @Column(name = "name")
    private  String name;

    @NotNull
    @Column(name = "location")
    private  String location;
}
