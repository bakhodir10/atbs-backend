package com.atbs.airplane;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
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
        fill(item, airplane);
        super.save(airplane);
    }

    @Override
    public Airplane update(Long id, AirplaneItem item) {
        Airplane airplane = findOne(id);
        fill(item, airplane);
        return airplane;
    }

    private void fill(AirplaneItem item, Airplane airplane) {
        if (!item.getName().isEmpty()) airplane.setName(item.getName());
        airplane.setCapacity(item.getCapacity());
    }
}
