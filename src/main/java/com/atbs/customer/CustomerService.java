package com.atbs.customer;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface CustomerService extends BaseService<Customer> {
    Customer create(CustomerItem item);

    Customer update(Long id, CustomerItem item);
}
