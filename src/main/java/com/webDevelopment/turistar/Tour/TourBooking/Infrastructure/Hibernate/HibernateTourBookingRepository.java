package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;

import java.util.List;
import java.util.Optional;

public class HibernateTourBookingRepository implements TourBookingRepository {


    @Override
    public void update(TourBooking tourBooking) {

    }

    @Override
    public Optional<TourBooking> find(String TourBookingId) {
        return Optional.empty();
    }

    @Override
    public Optional<TourBooking> findByUser(String UserId) {
        return Optional.empty();
    }

    @Override
    public void save(TourBooking tourBookings) {

    }

    @Override
    public Optional<List<TourBooking>> all(String userId) {
        return Optional.empty();
    }
}
