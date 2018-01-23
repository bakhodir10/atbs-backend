package com.atbs.companyAdminUser;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyAdminUserServiceImpl extends BaseServiceImpl<CompanyAdminUser> implements CompanyAdminUserService {

    private CompanyAdminUserRepository repository;

    @Autowired
    public void setCompanyRepository(CompanyAdminUserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<CompanyAdminUser> getRepository() {
        return repository;
    }

    @Override
    public void create(CompanyAdminUserItem item) {
        CompanyAdminUser company = new CompanyAdminUser();
        validate(item, company);
        super.save(company);
    }

    @Override
    public CompanyAdminUser update(Long id, CompanyAdminUserItem item) {
        CompanyAdminUser company = findOne(id);
        validate(item, company);
        return company;
    }

    private void validate(CompanyAdminUserItem item, CompanyAdminUser cmpAdminUser) {
        if (!item.getFullName().isEmpty()) cmpAdminUser.setFullName(item.getFullName());
    }
}
