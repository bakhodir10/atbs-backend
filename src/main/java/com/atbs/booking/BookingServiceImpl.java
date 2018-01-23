package com.atbs.booking;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends BaseServiceImpl<Booking> implements BookingService {

    private BookingRepository repository;

    @Autowired
    public void setCompanyRepository(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Booking> getRepository() {
        return repository;
    }

    @Override
    public void create(BookingItem item) {
        Booking booking = new Booking();
        //validate(item, booking);
        super.save(booking);
    }

    @Override
    public Booking update(Long id, BookingItem item) {
        Booking booking = findOne(id);
        //validate(item, booking);
        return booking;
    }

/*    private void validate(BookingItem item, Booking booking) {
        if (!item.getFlight().isEmpty()) company.setName(item.getName());
    }*/
}
