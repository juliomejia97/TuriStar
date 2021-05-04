package com.webDevelopment.turistar.Tour.TourBooking.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;

import java.time.LocalDate;

public class TourBookingCreator {

    private TourBookingRepository repository;

    public TourBookingCreator(TourBookingRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourBookingId, LocalDate tourBookingInitDate, LocalDate tourBookingEndDate)
    {
        TourBooking tourBooking = new TourBooking(new TourBookingId(tourBookingId), new TourBookingInitDate(tourBookingInitDate), new TourBookingEndDate(tourBookingEndDate));
        repository.save(tourBooking);
    }

}
