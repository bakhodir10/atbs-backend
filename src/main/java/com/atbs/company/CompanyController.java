package com.atbs.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public void setService(CompanyService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Company> getList() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company getOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void save(@RequestBody CompanyItem item) {
        service.create(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Company update(@PathVariable Long id, @RequestBody CompanyItem item) {
        return service.update(id, item);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public void activate(@RequestBody CompanyItem item) {
        service.activate(item.getId());
    }

    @RequestMapping(value = "/deactivate", method = RequestMethod.POST)
    public void deactivate(@RequestBody CompanyItem item) {
        service.deactivate(item.getId());
    }
}