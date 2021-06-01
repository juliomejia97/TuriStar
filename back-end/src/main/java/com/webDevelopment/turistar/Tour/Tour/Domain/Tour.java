package com.webDevelopment.turistar.Tour.Tour.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.TourSpotDetail;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourBookings;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourName;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Tour {

    private TourId tourId;
    private TourName tourName;
    private TourBookings tourBookings;
    private TourPrice tourPrice;
    private Optional<List<TourSpotDetail>> tourSpots;

    private Tour(){}

    public Tour(TourId tourId, TourName tourName, TourBookings tourBookings, TourPrice tourPrice, List<TourSpotDetail> tourSpots) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourBookings = tourBookings;
        this.tourPrice = tourPrice;
        this.tourSpots = Optional.ofNullable(tourSpots);
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
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", tourId.value());
            put("name", tourName.value());
            put("bookings", tourBookings.value());
            put("price", tourPrice.value());
        }};
        return data;
    }

}
