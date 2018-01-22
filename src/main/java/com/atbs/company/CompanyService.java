package com.atbs.company;

import com.atbs.base.BaseService;

public interface CompanyService extends BaseService<Company> {
    void create(CompanyItem item);

    Company update(Long id, CompanyItem item);
}
