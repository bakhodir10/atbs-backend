package com.atbs.companyAdminUser;

import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companiadminusers")
public class CompanyAdminUserController {
    private CompanyAdminUserService service;

    @Autowired
    public void setService(CompanyAdminUserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CompanyAdminUser> getList() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CompanyAdminUser getOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void save(@RequestBody CompanyAdminUserItem item) {
        service.create(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CompanyAdminUser update(@PathVariable Long id, @RequestBody CompanyAdminUserItem item) {
        return service.update(id, item);
    }
}
