package com.atbs.companyAdminUser;

import com.atbs.company.Company;
import com.atbs.user.UserItem;

public class CompanyAdminUserItem extends UserItem{
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
