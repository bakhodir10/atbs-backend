package com.atbs.flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    void create(FlightItem item);

    Flight update(Long id, FlightItem item);

    List<FlightItem> findAll();

    FlightItem findOne(Long id);

    Iterable<FlightItem> search(String flyingFrom, String flyingTo, Date date);
}
