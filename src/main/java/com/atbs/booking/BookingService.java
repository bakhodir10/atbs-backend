package com.atbs.booking;

import com.atbs.base.BaseService;

public interface BookingService extends BaseService<Booking> {
    void create(BookingItem item);

    Booking update(Long id, BookingItem item);
}
