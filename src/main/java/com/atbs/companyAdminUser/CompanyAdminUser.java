package com.atbs.companyAdminUser;

import com.atbs.company.Company;
import com.atbs.user.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "companyAdminsUser")
public class CompanyAdminUser extends User {
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "company")
    private Company company;
}
