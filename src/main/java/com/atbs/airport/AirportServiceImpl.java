package com.atbs.airport;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl extends BaseServiceImpl<Airport> implements AirportService {

    private AirportRepository repository;

    @Autowired
    public void setCompanyRepository(AirportRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Airport> getRepository() {
        return repository;
    }

    @Override
    public Airport create(AirportItem item) {
        Airport airport = new Airport();
        validate(item, airport);
        super.save(airport);
        return airport;
    }

    @Override
    public Airport update(Long id, AirportItem item) {
        Airport airport = findOne(id);
        validate(item, airport);
        return airport;
    }

    private void validate(AirportItem item, Airport airport) {
        if (!item.getName().isEmpty()) airport.setName(item.getName());
        if (!item.getLocation().isEmpty()) airport.setLocation(item.getLocation());
    }

    public Airport findByName(String name){
        return repository.findByName(name);
    }
}
