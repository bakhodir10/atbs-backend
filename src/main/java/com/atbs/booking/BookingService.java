package com.atbs.booking;

import com.atbs.base.BaseService;

public interface BookingService extends BaseService<Booking> {
    Long create(BookingItem item);

    Booking update(Long id, BookingItem item);
}
