package com.atbs.flight;

import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private FlightService service;

    @Autowired
    public void setService(FlightService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Flight> getList() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Flight getOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<Flight> search(@RequestParam String flyingFrom, @RequestParam String flyingTo,  Date date) {
        return service.search(flyingFrom, flyingTo, date);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void save(@RequestBody FlightItem item) {
        service.create(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Flight update(@PathVariable Long id, @RequestBody FlightItem item) {
        return service.update(id, item);
    }
}
