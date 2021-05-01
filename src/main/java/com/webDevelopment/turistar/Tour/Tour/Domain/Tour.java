package com.webDevelopment.turistar.Tour.Tour.Domain;

import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourBookings;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourName;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourPrice;

public class Tour {

    private TourName tourName;
    private TourBookings tourBookings;
    private TourPrice tourPrice;

    public Tour(TourName tourName, TourBookings tourBookings, TourPrice tourPrice) {
        this.tourName = tourName;
        this.tourBookings = tourBookings;
        this.tourPrice = tourPrice;
    }
}
