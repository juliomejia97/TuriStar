package com.webDevelopment.turistar.Administrator.TourSpot.Domain;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;

import java.util.HashMap;
import java.util.Objects;

public class TourSpot {
    private TourSpotId tourSpotId;
    private TourSpotName tourSpotName;
    private TourSpotLatitude latitude;
    private TourSpotLongitude longitude;
    private TourSpotDescription description;
    private TourSpotActive tourSpotActive;
    public TourSpot(TourSpotId tourSpotId, TourSpotName tourSpotName, TourSpotLatitude latitude, TourSpotLongitude longitude, TourSpotDescription description) {
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotActive = new TourSpotActive(true);
    }

    private TourSpot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpot spot = (TourSpot)o;
        return Objects.equals(tourSpotId,spot.tourSpotId) &&
                Objects.equals(tourSpotName,spot.tourSpotName) &&
                Objects.equals(latitude,spot.latitude) &&
                Objects.equals(longitude,spot.longitude) &&
                Objects.equals(description,spot.description) &&
                Objects.equals(tourSpotActive,spot.tourSpotActive);
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<>() {{
            put("id", tourSpotId.value());
            put("name", tourSpotName.value());
            put("latitude",String.valueOf(latitude.value()));
            put("longitude",String.valueOf(longitude.value()));
            put("description",description.value());
            put("active",tourSpotActive.value().toString());
        }};
        return data;
    }

    public void updateTour(String tourName, Double latitude, Double longitude) {
        this.tourSpotName = new TourSpotName(tourName);
        this.latitude = new TourSpotLatitude(latitude);
        this.longitude = new TourSpotLongitude(longitude);
    }

    public Boolean equalsById(String idTourSpot){
        return this.tourSpotId.equals(new TourSpotId(idTourSpot));
    }

}
