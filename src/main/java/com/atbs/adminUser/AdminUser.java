package com.atbs.adminUser;

import com.atbs.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "adminUser")
public class AdminUser extends User {
}
