package com.webDevelopment.turistar.Shared.Domain.TourBooking;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TourBookedEventDomain extends DomainEvent {
    private String tourBookingId;
    private String tourBookingInitDate;
    private String tourBookingEndDate;

    private TourBookedEventDomain(){
        this.tourBookingId = null;
        this.tourBookingInitDate = null;
        this.tourBookingEndDate = null;
    }

    public TourBookedEventDomain(String aggregateId, String eventId, String occurredOn,
                                 String tourBookingId,
                                 String tourBookingInitDate,
                                 String tourBookingEndDate) {
        super(aggregateId, eventId, occurredOn);
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
    }

    public TourBookedEventDomain(String aggregateId, String tourBookingId, String tourBookingInitDate,
                                 String tourBookingEndDate) {
        super(aggregateId);
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
    }

    @Override
    public String eventName() {
        return "tourBooking.booked";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("tourBookingInitDate",tourBookingInitDate);
            put("tourBookingEndDate",tourBookingEndDate);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TourBookedEventDomain(aggregateId, eventId, occurredOn,
                (String) body.get("tourBookingId"),
                (String)body.get("tourBookingInitDate"),
                (String) body.get("tourBookingEndDate"));
    }

    public String getTourBookingId() {
        return tourBookingId;
    }
    public String getTourBookingInitDate() {
        return tourBookingInitDate;
    }

    public String getTourBookingEndDate() {
        return tourBookingEndDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourBookedEventDomain that = (TourBookedEventDomain) o;
        return Objects.equals(tourBookingInitDate, that.tourBookingInitDate) &&
                Objects.equals(tourBookingEndDate, that.tourBookingEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourBookingInitDate, tourBookingEndDate);
    }
}
