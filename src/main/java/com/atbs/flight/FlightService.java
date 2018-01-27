package com.atbs.flight;

import com.atbs.base.BaseService;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;

import java.util.Date;

public interface FlightService extends BaseService<Flight> {
    void create(FlightItem item);

    Flight update(Long id, FlightItem item);
    public Iterable<Flight> search(String flyingFrom, String flyingTo, Date date);
}
