package com.atbs.adminUser;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface AdminUserService extends BaseService<AdminUser> {
    void create(AdminUserItem item);

    AdminUser update(Long id, AdminUserItem item);

    //approve the company if it is genuine
    boolean approveCompany(Company company);

    //suspend the company if its not genuine
    void suspendCompany(int companyId);
}
