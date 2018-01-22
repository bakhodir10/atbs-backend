package com.atbs.company;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public void setCompanyRepository(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Company> getRepository() {
        return repository;
    }

    @Override
    public void create(CompanyItem item) {
        Company company = new Company();
        validate(item, company);
        super.save(company);
    }

    @Override
    public Company update(Long id, CompanyItem item) {
        Company company = findOne(id);
        validate(item, company);
        return company;
    }

    private void validate(CompanyItem item, Company company) {
        if (!item.getName().isEmpty()) company.setName(item.getName());
    }
}
