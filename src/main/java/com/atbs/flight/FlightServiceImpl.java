package com.atbs.flight;

import com.atbs.airport.Airport;
import com.atbs.airport.AirportRepository;
import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import  java.util.List;

@Service
public class FlightServiceImpl extends BaseServiceImpl<Flight> implements FlightService {

    private FlightRepository repository;
    private AirportRepository airportRepository;

    @Autowired
    public void setCompanyRepository(FlightRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setAirportRepository(AirportRepository airportRepository){this.airportRepository = airportRepository;}

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

    public Iterable<Flight> search(String flyingFrom, String flyingTo, Date date){
        List<Flight> flightList = new ArrayList<>();
        Iterable<Flight> iFlightList = repository.findAll();

        for(Flight flight : iFlightList){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            if(flight.getFrom().getLocation().toLowerCase().contains(flyingFrom.toLowerCase()) && flight.getTo().getLocation().toLowerCase().contains(flyingTo.toLowerCase()) &&sdf.format(flight.getDate()).equals(sdf.format(date))){
                flightList.add(flight);
            }
        }

        return  flightList;
    }


    /*private void validate(FlightItem item, Flight flight) {
        if (!item.getDate().isEmpty()) company.setName(item.getName());
    }*/
}
