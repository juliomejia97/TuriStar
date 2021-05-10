package com.webDevelopment.turistar.Tour.Tour.Domain;

import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourBookings;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourName;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourPrice;

import java.util.*;

public class Tour {

    private TourId tourId;
    private TourName tourName;
    private TourBookings tourBookings;
    private TourPrice tourPrice;
    //private List<TourSpotId> tourSpots;

    private Tour(){}

    public Tour(TourName tourName, TourBookings tourBookings, TourPrice tourPrice) {
        this.tourName = tourName;
        this.tourBookings = tourBookings;
        this.tourPrice = tourPrice;
        //this.tourSpots = new ArrayList<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(tourId, tour.tourId) &&
                Objects.equals(tourName, tour.tourName) &&
                Objects.equals(tourBookings, tour.tourBookings) &&
                Objects.equals(tourPrice, tour.tourPrice);
                //Objects.equals(tourSpots, tour.tourSpots);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", tourId.value());
            put("name", tourName.value());
            put("name", tourName.value());
            put("bookings", tourBookings.value());
            put("price", tourPrice.value());
        }};
        return data;
    }

}
