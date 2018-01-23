package com.atbs.companyAdminUser;

import com.atbs.company.Company;
import com.atbs.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "companyAdminsUser")
public class CompanyAdminUser extends User {
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
