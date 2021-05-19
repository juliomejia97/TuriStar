package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class TourSpotDetail {
    private String tourSpotName;
    private Double latitude;
    private Double longitude;
    private String description;

    public TourSpotDetail(String tourSpotName, Double latitude, Double longitude, String description) {
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }
    private TourSpotDetail(){}
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("name", tourSpotName);
            put("latitude", latitude);
            put("longitude", longitude);
            put("description",description);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpotDetail that = (TourSpotDetail) o;
        return Objects.equals(tourSpotName, that.tourSpotName) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(description, that.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(tourSpotName, latitude, longitude, description);
    }
}
