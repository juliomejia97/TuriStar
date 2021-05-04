package com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions.TourBookingNotFound;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import java.util.List;
import java.util.Optional;

public class TourBookingsAllByUser {

    private TourBookingRepository repository;

    public TourBookingsAllByUser(TourBookingRepository repository) {
        this.repository = repository;
    }

    public List<TourBooking> execute(String userId) {
        Optional<List<TourBooking>> tourBookings = repository.all(userId);
        if(tourBookings.isEmpty()){
            throw new TourBookingNotFound("There are no cities in the database, contact your admin");
        }
        //TODO: Get only active cities
        return tourBookings.get();
    }
}
