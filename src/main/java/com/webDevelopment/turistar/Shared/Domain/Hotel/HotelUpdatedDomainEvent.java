package com.webDevelopment.turistar.Shared.Domain.Hotel;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class HotelUpdatedDomainEvent extends DomainEvent {
    private String hotelId;
    private String hotelName;
    private Double hotelStars;
    private String hotelAddress;
    private HashMap<String,Object> hotelPhotos;

    public HotelUpdatedDomainEvent() {
        this.hotelId = "";
        this.hotelName = "";
        this.hotelStars = 0.0;
        this.hotelAddress = "";
        this.hotelPhotos = null;
    }

    public HotelUpdatedDomainEvent(String aggregateId, String hotelId, String hotelName,
                                   Double hotelStars, String hotelAddress, HashMap<String, Object> hotelPhotos) {
        super(aggregateId);
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }

    public HotelUpdatedDomainEvent(String aggregateId, String eventId, String occurredOn,
                                   String hotelId, String hotelName, Double hotelStars, String hotelAddress, HashMap<String, Object> hotelPhotos) {
        super(aggregateId, eventId, occurredOn);
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }

    @Override
    public String eventName() {
        return "event.hotelUpdated";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("hotelId",hotelId);
            put("hotelName",hotelName);
            put("hotelStars",hotelStars);
            put("hotelAddress",hotelAddress);
            put("hotelPhotos",hotelPhotos);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new HotelUpdatedDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("hotelId"),
                (String) body.get("hotelName"),
                (Double)body.get("hotelStars"),
                (String)body.get("hotelAddress"),
                (HashMap<String,Object>) body.get("hotelPhotos"));
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Double getHotelStars() {
        return hotelStars;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public HashMap<String, Object> getHotelPhotos() {
        return hotelPhotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelUpdatedDomainEvent that = (HotelUpdatedDomainEvent) o;
        return Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(hotelName, that.hotelName) &&
                Objects.equals(hotelStars, that.hotelStars) &&
                Objects.equals(hotelAddress, that.hotelAddress) &&
                Objects.equals(hotelPhotos, that.hotelPhotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelName, hotelStars, hotelAddress, hotelPhotos);
    }
}
