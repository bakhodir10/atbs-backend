package com.atbs.airplane;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl extends BaseServiceImpl<Airplane> implements AirplaneService {
    private AirplaneRepository repository;

    @Autowired
    public void setCompanyRepository(AirplaneRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Airplane> getRepository() {
        return repository;
    }

    @Override
    public void create(AirplaneItem item) {
        Airplane airplane = new Airplane();
        validate(item, airplane);
        super.save(airplane);
    }

    @Override
    public Airplane update(Long id, AirplaneItem item) {
        Airplane airplane = findOne(id);
        validate(item, airplane);
        return airplane;
    }

    private void validate(AirplaneItem item, Airplane airplane) {
        if (!item.getName().isEmpty()) airplane.setName(item.getName());
    }
}
