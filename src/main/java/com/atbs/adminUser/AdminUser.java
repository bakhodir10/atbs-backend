package com.atbs.adminUser;

import com.atbs.company.Company;
import com.atbs.user.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "adminUser")
public class AdminUser extends User {
}
