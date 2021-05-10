package com.webDevelopment.turistar.Administrator.TourSpot.Domain;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotUpdatedDomainEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class TourSpot extends AggregateRoot {

    private TourSpotId tourSpotId;
    private CityId cityId;
    private TourSpotName tourSpotName;
    private TourSpotLatitude latitude;
    private TourSpotLongitude longitude;
    private TourSpotDescription description;
    private TourSpotActive tourSpotActive;
    private TourId tourId;

    public TourSpot(TourSpotId tourSpotId, CityId cityId,TourSpotName tourSpotName, TourSpotLatitude latitude, TourSpotLongitude longitude, TourSpotDescription description, TourId tourId) {
        this.tourSpotId = tourSpotId;
        this.cityId = cityId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotActive = new TourSpotActive(true);
        this.tourId = tourId;
    }

    private TourSpot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpot tourSpot = (TourSpot) o;
        return Objects.equals(tourSpotId, tourSpot.tourSpotId) && Objects.equals(cityId, tourSpot.cityId) && Objects.equals(tourSpotName, tourSpot.tourSpotName) && Objects.equals(latitude, tourSpot.latitude) && Objects.equals(longitude, tourSpot.longitude) && Objects.equals(description, tourSpot.description) && Objects.equals(tourSpotActive, tourSpot.tourSpotActive) && Objects.equals(tourId, tourSpot.tourId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourSpotId, cityId, tourSpotName, latitude, longitude, description, tourSpotActive, tourId);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", tourSpotId.value());
            put("cityId",cityId.value());
            put("name", tourSpotName.value());
            put("latitude",String.valueOf(latitude.value()));
            put("longitude",String.valueOf(longitude.value()));
            put("description",description.value());
            put("active",tourSpotActive.value().toString());
            put("tourId",tourId.value());
        }};
        return data;
    }

    public void updateTour(String tourName, Double latitude, Double longitude, String description) {
        this.tourSpotName = new TourSpotName(tourName);
        this.latitude = new TourSpotLatitude(latitude);
        this.longitude = new TourSpotLongitude(longitude);
        this.description = new TourSpotDescription(description);

        this.record(new TourSpotUpdatedDomainEvent(this.tourId.value(),  this.tourSpotId.value(), this.tourSpotName.value(), this.latitude.value(), this.longitude.value(), this.description.value(), this.tourSpotActive.value()) );
    }

    public Boolean equalsById(String idTourSpot){
        return this.tourSpotId.equals(new TourSpotId(idTourSpot));
    }

}
