package com.atbs.user;

import com.atbs.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class User extends BaseEntity {
    @Column(name = "full_name")
    @NotNull
    private  String fullName;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

}
