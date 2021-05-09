package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class TourSpotDetail {
    private String tourSpotId;
    private String tourSpotName;
    private Double latitude;
    private Double longitude;
    private String description;
    private Boolean tourSpotActive;

    public TourSpotDetail(String tourSpotId, String tourSpotName, Double latitude, Double longitude, String description, Boolean tourSpotActive) {
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotActive = tourSpotActive;
    }
    private TourSpotDetail(){}
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", tourSpotId);
            put("name", tourSpotName);
            put("latitude", latitude);
            put("longitude", longitude);
            put("description",description);
            put("active", tourSpotActive);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpotDetail that = (TourSpotDetail) o;
        return Objects.equals(tourSpotId, that.tourSpotId) &&
                Objects.equals(tourSpotName, that.tourSpotName) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tourSpotActive, that.tourSpotActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourSpotId, tourSpotName, latitude, longitude, description, tourSpotActive);
    }
    public boolean equalsTourSpotsId(String tourSpotId) {
        return this.tourSpotId.equals(tourSpotId);
    }
}
