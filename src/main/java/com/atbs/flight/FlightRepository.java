package com.atbs.flight;

import com.atbs.airport.Airport;
import com.atbs.base.BaseRepository;
import com.atbs.company.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface FlightRepository extends BaseRepository<Flight> {

}
