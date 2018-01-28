package com.atbs.companyAdminUser;

import com.atbs.company.Company;
import com.atbs.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "companyAdminsUser")
public class CompanyAdminUser extends User {

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
