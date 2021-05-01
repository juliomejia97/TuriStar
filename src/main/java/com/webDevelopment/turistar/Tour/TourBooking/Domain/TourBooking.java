package com.webDevelopment.turistar.Tour.TourBooking.Domain;

import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;

public class TourBooking {

    TourBookingInitDate tourBookingInitDate;
    TourBookingEndDate tourBookingEndDate;

    public TourBooking(TourBookingInitDate tourBookingInitDate, TourBookingEndDate tourBookingEndDate) {
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
    }
}
