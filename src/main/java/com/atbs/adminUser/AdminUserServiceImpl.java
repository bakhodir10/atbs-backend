package com.atbs.adminUser;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser> implements  AdminUserService{
    private AdminUserRepository repository;

    @Autowired
    public void setCompanyRepository(AdminUserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<AdminUser> getRepository() {
        return repository;
    }

    @Override
    public void create(AdminUserItem item) {
        AdminUser adminUser = new AdminUser();
        validate(item, adminUser);
        super.save(adminUser);
    }

    @Override
    public AdminUser update(Long id, AdminUserItem item) {
        AdminUser adminUser = findOne(id);
        validate(item, adminUser);
        return adminUser;
    }

    private void validate(AdminUserItem item, AdminUser adminUser) {
        if (!item.getFullName().isEmpty()) adminUser.setFullName(item.getFullName());
    }

    //approve the company if it is genuine
    public boolean approveCompany(Company company){
        return  false;
    }

    //suspend the company if its not genuine
    public void suspendCompany(int companyId){}
}
