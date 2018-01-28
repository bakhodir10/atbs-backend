package com.atbs.airplane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {
    private AirplaneService service;

    @Autowired
    public void setService(AirplaneService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airplane> getList() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Airplane getOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping(value = "/create")
    public Airplane save(@RequestBody AirplaneItem airplane) {
        return service.create(airplane);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Airplane update(@PathVariable Long id, @RequestBody AirplaneItem item) {
        return service.update(id, item);
    }
}
