package com.webDevelopment.turistar.Tour.TourBooking.Application.Delete;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions.TourBookingNotFound;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;

import java.util.Optional;

public class TourBookingDelete {

    private TourBookingRepository tourBookingRepository;

    public TourBookingDelete(TourBookingRepository tourBookingRepository){
        this.tourBookingRepository = tourBookingRepository;
    }

    public void execute(String cityId) {
        Optional<TourBooking> tourBookingUpdated = tourBookingRepository.find(cityId);
        if(tourBookingUpdated.isEmpty()){
            throw new TourBookingNotFound("The Tour Booking doesn't exist");
        }
        TourBooking tourBookingToUpdate = tourBookingUpdated.get();
        tourBookingToUpdate.deleteTourBooking();
        this.tourBookingRepository.update(tourBookingToUpdate);
    }
}
