package com.atbs.airport;

import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    private AirportService service;

    @Autowired
    public void setService(AirportService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airport> getList() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Airport getOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping(value = "/create")
    public Airport save(@RequestBody AirportItem item) {
        return service.create(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Airport update(@PathVariable Long id, @RequestBody AirportItem item) {
        return service.update(id, item);
    }
}
