package com.atbs.companyAdminUser;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface CompanyAdminUserService extends BaseService<CompanyAdminUser> {
    void create(CompanyAdminUserItem item);

    CompanyAdminUser update(Long id, CompanyAdminUserItem item);
}
