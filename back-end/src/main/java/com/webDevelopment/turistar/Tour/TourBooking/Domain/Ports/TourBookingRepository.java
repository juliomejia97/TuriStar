package com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;

import java.util.List;
import java.util.Optional;

public interface TourBookingRepository {
    void update(TourBooking tourBooking);
    Optional<TourBooking> find(String TourBookingId);
    void save(TourBooking tourBookings);
    Optional<List<TourBooking>> all();
}
