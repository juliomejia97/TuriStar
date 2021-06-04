package com.webDevelopment.turistar.Tour.Tour.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.TourSpotDetail;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourBookings;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourDescription;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourName;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourPrice;

import java.util.*;

public class Tour {

    private TourId tourId;
    private TourName tourName;
    private TourDescription tourDescription;
    private TourBookings tourBookings;
    private TourPrice tourPrice;
    private Optional<List<TourSpotId>> tourSpots;

    private Tour(){}

    public Tour(TourId tourId, TourName tourName, TourDescription tourDescription,
                TourBookings tourBookings, TourPrice tourPrice, List<TourSpotId> tourSpots) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.tourBookings = tourBookings;
        this.tourPrice = tourPrice;
        this.tourSpots = Optional.ofNullable(tourSpots);
    }
    public static Tour create(TourId tourId, TourName tourName, TourDescription tourDescription,
                              TourBookings tourBookings, TourPrice tourPrice, List<TourSpotId> tourSpots){
        Tour newTour = new Tour(tourId,tourName,tourDescription,tourBookings,tourPrice,tourSpots);
        return newTour;
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
            put("description",tourDescription.value());
            put("bookings", tourBookings.value());
            put("price", tourPrice.value());
            put("tourSpotsId",dataToursId());
        }};
        return data;
    }

    private ArrayList<String> dataToursId(){
        ArrayList<String> response = new ArrayList<>();
        if(this.tourSpots.isPresent()){
            List<TourSpotId> tourSpotIds = this.tourSpots.get();
            tourSpotIds.stream().forEach(tourSpotId -> response.add(tourSpotId.value()));
        }
        return response;
    }

}
