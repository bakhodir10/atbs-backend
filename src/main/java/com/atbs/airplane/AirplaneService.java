package com.atbs.airplane;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface AirplaneService extends BaseService<Airplane> {
    void create(AirplaneItem item);

    Airplane update(Long id, AirplaneItem item);
}
