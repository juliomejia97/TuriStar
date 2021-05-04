package com.webDevelopment.turistar.Tour.TourBooking.Domain;

import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingActive;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingEndDate;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects.TourBookingInitDate;

import java.util.HashMap;

public class TourBooking {

    TourBookingId tourBookingId;
    TourBookingInitDate tourBookingInitDate;
    TourBookingEndDate tourBookingEndDate;
    TourBookingActive tourBookingActive;

    public TourBooking(TourBookingId tourBookingId, TourBookingInitDate tourBookingInitDate, TourBookingEndDate tourBookingEndDate) {
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
        this.tourBookingActive = new TourBookingActive(true);
    }

    public void deleteTourBooking() {
        tourBookingActive = new TourBookingActive(false);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", tourBookingId.value());
            put("tourBookingInitDate", tourBookingInitDate.value());
            put("tourBookingEndDate", tourBookingEndDate.value());
            put("tourBookingActive", tourBookingActive.value());
        }};
        return data;
    }
}
