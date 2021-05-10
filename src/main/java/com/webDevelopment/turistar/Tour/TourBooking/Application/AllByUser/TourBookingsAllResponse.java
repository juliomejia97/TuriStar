package com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourBookingsAllResponse {
    private List<TourBooking> tourBookings;

    public TourBookingsAllResponse(List<TourBooking> tourBookings) {
        this.tourBookings = tourBookings;
    }

    public List<HashMap<String,Object>> response()
    {
        return tourBookings.stream().map(TourBooking::data).collect(Collectors.toList());
    }
}
