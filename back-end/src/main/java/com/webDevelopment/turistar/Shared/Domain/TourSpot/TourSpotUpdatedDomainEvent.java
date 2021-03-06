package com.webDevelopment.turistar.Shared.Domain.TourSpot;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TourSpotUpdatedDomainEvent extends DomainEvent {

    private String tourSpotId;
    private String tourSpotName;
    private Double latitude;
    private Double longitude;
    private String description;
    private ArrayList<String> tourSpotPhotos;
    private Boolean tourEventType;

    public TourSpotUpdatedDomainEvent(String aggregateId, String tourSpotId, String tourSpotName, Double latitude,
                                      Double longitude, String description, ArrayList<String> tourSpotPhotos ,Boolean tourEventType) {
        super(aggregateId);
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotPhotos = tourSpotPhotos;
        this.tourEventType = tourEventType;
    }

    public TourSpotUpdatedDomainEvent(String aggregateId, String eventId, String occurredOn, String tourSpotId,
                                      String tourSpotName, Double latitude, Double longitude, String description, ArrayList<String> tourSpotPhotos,Boolean tourEventType) {
        super(aggregateId, eventId, occurredOn);
        this.tourSpotId = tourSpotId;
        this.tourSpotName = tourSpotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.tourSpotPhotos = tourSpotPhotos;
        this.tourEventType = tourEventType;
    }

    private TourSpotUpdatedDomainEvent() {
        this.tourSpotId = null;
        this.tourSpotName = null;
        this.latitude = null;
        this.longitude = null;
        this.description = null;
        this.tourSpotPhotos = null;
        this.tourEventType = null;
    }

    @Override
    public String eventName() {
        return "tourSpot.updated";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("tourSpotId",tourSpotId);
            put("tourSpotName",tourSpotName);
            put("latitude",latitude);
            put("longitude",longitude);
            put("description",description);
            put("photos",tourSpotPhotos);
            put("tourEventType",tourEventType);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TourSpotUpdatedDomainEvent(aggregateId, eventId, occurredOn,
                (String)body.get("tourSpotId"),
                (String) body.get("tourSpotName"),
                (Double)body.get("latitude"),
                (Double) body.get("longitude"),
                (String)body.get("description"),
                (ArrayList<String>)body.get("photos"),
                (Boolean)body.get("tourEventType"));
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

    public Boolean getTourEventType() {
        return tourEventType;
    }

    public ArrayList<String> getTourSpotPhotos() {
        return tourSpotPhotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourSpotUpdatedDomainEvent that = (TourSpotUpdatedDomainEvent) o;
        return  Objects.equals(tourSpotId,that.tourSpotId) &&
                Objects.equals(tourSpotName, that.tourSpotName) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tourSpotPhotos, that.tourSpotPhotos) &&
                Objects.equals(tourEventType, that.tourEventType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourSpotId, tourSpotName, latitude, longitude, description, tourSpotPhotos, tourEventType);
    }
}
