package com.atbs.booking;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.company.Company;
import com.atbs.company.CompanyItem;
import com.atbs.company.CompanyRepository;
import com.atbs.company.CompanyService;
import com.atbs.customer.Customer;
import com.atbs.customer.CustomerRepository;
import com.atbs.flight.Flight;
import com.atbs.flight.FlightItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atbs.customer.CustomerService;

@Service
public class BookingServiceImpl extends BaseServiceImpl<Booking> implements BookingService {

    private BookingRepository repository;
    private CustomerService custemerService;

    @Autowired
    public void setCompanyRepository(BookingRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setCustomerService(CustomerService custemerService){
        this.custemerService = custemerService;
    }

    @Override
    protected BaseRepository<Booking> getRepository() {
        return repository;
    }

    @Override
    public Long create(BookingItem item) {
        Booking booking = new Booking();
        booking.setCustomer(custemerService.create(item.getCustomer()));
        booking.setFlight(item.getFlight().getEntity());
        super.save(booking);
        return booking.getId();
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
