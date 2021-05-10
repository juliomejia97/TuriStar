package com.webDevelopment.turistar.Tour.TourBooking.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;
import com.webDevelopment.turistar.User.User.Domain.User;

import java.time.LocalDate;

public class TourBookingCreator {

    private TourBookingRepository repository;

    public TourBookingCreator(TourBookingRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourBookingId, LocalDate tourBookingInitDate, LocalDate tourBookingEndDate, String tourId, String userId)
    {
        TourBooking tourBooking = new TourBooking(new TourBookingId(tourBookingId), new TourBookingInitDate(tourBookingInitDate), new TourBookingEndDate(tourBookingEndDate), new TourId(tourId),  new UserId(userId));
        repository.save(tourBooking);
    }

}
