package com.atbs.flight;

import com.atbs.airport.Airport;
import com.atbs.airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository repository;
    private AirportRepository airportRepository;

    @Autowired
    public void setCompanyRepository(FlightRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setAirportRepository(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public FlightItem create(FlightItem item) {
        Flight company = new Flight();
        validate(item, company);
        this.repository.save(company);
        return item;
    }

    @Override
    public Flight update(Long id, FlightItem item) {
        Flight company = repository.findOne(id);
        // validate(item, company);
        return company;
    }

    @Override
    public List<FlightItem> findAll() {
        List<FlightItem> items = new LinkedList<>();
        repository.findAll().forEach(e -> items.add(e.getFlightItem()));
        return items;
    }

    @Override
    public FlightItem findOne(Long id) {
        return repository.findOne(id).getFlightItem();
    }

    public Iterable<FlightItem> search(String flyingFrom, String flyingTo, Date date) {
        List<FlightItem> flightList = new ArrayList<>();
        Iterable<Flight> iFlightList = repository.findAll();

        for (Flight flight : iFlightList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            if (flight.getFrom().getLocation().toLowerCase().contains(flyingFrom.toLowerCase()) && flight.getTo().getLocation().toLowerCase().contains(flyingTo.toLowerCase()) && sdf.format(flight.getDate()).equals(sdf.format(date))) {
                flightList.add(flight.getFlightItem());
            }
        }
        return flightList;
    }

    private void validate(FlightItem item, Flight flight) {
        if (item.getDate() != null) flight.setDate(item.getDate());
        if (item.getTime() != null) flight.setTime(item.getTime());
        if (item.getFrom() != null) {
            Airport from = airportRepository.findOne(item.getFrom().getId());
            flight.setFrom(from);
        }
        if (item.getTime() != null) {
            Airport to = airportRepository.findOne(item.getTo().getId());
            flight.setTo(to);
        }
        flight.setPrice(item.getPrice());
    }
}
