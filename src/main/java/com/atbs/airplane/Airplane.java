package com.atbs.airplane;

import com.atbs.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "airplane")
public class Airplane extends BaseEntity {
    @NotNull
    @Column(name = "name")
    private  String name;

    @NotNull
    @Column(name = "capacity")
    private  int  capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
