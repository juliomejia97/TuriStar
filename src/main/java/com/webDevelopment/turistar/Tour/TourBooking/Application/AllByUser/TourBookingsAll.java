package com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions.TourBookingNotFound;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import java.util.List;
import java.util.Optional;

public class TourBookingsAll {

    private TourBookingRepository repository;

    public TourBookingsAll(TourBookingRepository repository) {
        this.repository = repository;
    }

    public List<TourBooking> execute() throws RuntimeException{
        Optional<List<TourBooking>> tourBookings = repository.all();
        if(tourBookings.get().isEmpty()){
            throw new TourBookingNotFound("There are no tour bookings in the database, contact your admin");
        }
        return tourBookings.get();
    }
}
