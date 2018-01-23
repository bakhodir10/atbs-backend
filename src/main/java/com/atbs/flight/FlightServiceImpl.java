package com.atbs.flight;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl extends BaseServiceImpl<Flight> implements FlightService {

    private FlightRepository repository;

    @Autowired
    public void setCompanyRepository(FlightRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Flight> getRepository() {
        return repository;
    }

    @Override
    public void create(FlightItem item) {
        Flight company = new Flight();
        //validate(item, company);
        super.save(company);
    }

    @Override
    public Flight update(Long id, FlightItem item) {
        Flight company = findOne(id);
       // validate(item, company);
        return company;
    }

    /*private void validate(FlightItem item, Flight flight) {
        if (!item.getDate().isEmpty()) company.setName(item.getName());
    }*/
}
