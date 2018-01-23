package com.atbs.customer;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public void setCompanyRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Customer> getRepository() {
        return repository;
    }

    @Override
    public void create(CustomerItem item) {
        Customer customer = new Customer();
        validate(item, customer);
        super.save(customer);
    }

    @Override
    public Customer update(Long id, CustomerItem item) {
        Customer customer = findOne(id);
        validate(item, customer);
        return customer;
    }

    private void validate(CustomerItem item, Customer customer) {
        if (!item.getFullName().isEmpty()) customer.setFullName(item.getFullName());
    }
}
