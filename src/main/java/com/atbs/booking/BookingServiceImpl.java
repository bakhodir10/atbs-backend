package com.atbs.booking;

import com.atbs.base.BaseRepository;
import com.atbs.base.BaseServiceImpl;
import com.atbs.customer.CustomerService;
import com.atbs.flight.Flight;
import com.atbs.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends BaseServiceImpl<Booking> implements BookingService {

    private BookingRepository repository;
    private CustomerService custemerService;
    private FlightRepository flightRepository;

    @Autowired
    public void setCompanyRepository(BookingRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setCustomerService(CustomerService custemerService) {
        this.custemerService = custemerService;
    }

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    protected BaseRepository<Booking> getRepository() {
        return repository;
    }

    @Override
    public Long create(BookingItem item) {
        Booking booking = new Booking();
        booking.setCustomer(custemerService.create(item.getCustomer()));
        if (item.getFlight() != null) {
            Flight flight = flightRepository.findOne(item.getFlight().getId());
            booking.setFlight(flight);
        }
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
