package com.webDevelopment.turistar.Shared.Domain.TourSpot;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TourSpotCreatedEventDomain extends DomainEvent {
    private String tourSpotId;
    private String tourSpotName;
    private Double latitude;
    private Double longitude;
    private String description;
    private Boolean tourSpotActive;
    private ArrayList<String> tourSpotPhotos;


    public TourSpotCreatedEventDomain() {
        this.tourSpotName = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.description = "";
        this.tourSpotActive = false;
    }

    public TourSpotCreatedEventDomain(String aggregateId, String tourSpotId,String tourSpotName, Double latitude, Double longitude, String description, ArrayList<String> tourSpotPhotos,Boolean tourSpotActive) {
        super(aggregateId);
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotPhotos = tourSpotPhotos;
        this.tourSpotActive = tourSpotActive;
    }

    public TourSpotCreatedEventDomain(String aggregateId, String eventId, String occurredOn,
                                      String tourSpotId, String tourSpotName, Double latitude, Double longitude, String description, ArrayList<String> tourSpotPhotos,Boolean tourSpotActive) {
        super(aggregateId, eventId, occurredOn);
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotPhotos = tourSpotPhotos;
        this.tourSpotActive = tourSpotActive;
    }

    @Override
    public String eventName() {
        return "tourSpot.created";
    }

    public String getTourSpotId() {
        return tourSpotId;
    }

    public String getTourSpotName() {
        return tourSpotName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTourSpotPhotos() {
        return tourSpotPhotos;
    }

    public Boolean getTourSpotActive() {
        return tourSpotActive;
    }


    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("tourSpotId",tourSpotId);
            put("tourSpotName",tourSpotName);
            put("latitude",latitude);
            put("longitude",longitude);
            put("description",description);
            put("tourSpotActive",tourSpotActive);
            put("photos",tourSpotPhotos);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TourSpotCreatedEventDomain(aggregateId, eventId, occurredOn,
                (String)body.get("tourSpotId"),
                (String)body.get("tourSpotName"),
                (Double)body.get("latitude"),
                (Double)body.get("longitude"),
                (String)body.get("description"),
                (ArrayList<String>)body.get("photos"),
                (Boolean) body.get("tourSpotActive"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpotCreatedEventDomain that = (TourSpotCreatedEventDomain) o;
        return  Objects.equals(tourSpotName, that.tourSpotName) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tourSpotActive, that.tourSpotActive) &&
                Objects.equals(tourSpotPhotos,that.tourSpotPhotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourSpotName, latitude, longitude, description, tourSpotPhotos,tourSpotActive);
    }
}
