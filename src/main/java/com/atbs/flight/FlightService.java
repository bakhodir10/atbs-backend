package com.atbs.flight;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface FlightService extends BaseService<Flight> {
    void create(FlightItem item);

    Flight update(Long id, FlightItem item);
}
