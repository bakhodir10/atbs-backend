package com.atbs.airport;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

public interface AirportService extends BaseService<Airport> {
    void create(AirportItem item);

    Airport update(Long id, AirportItem item);
}
