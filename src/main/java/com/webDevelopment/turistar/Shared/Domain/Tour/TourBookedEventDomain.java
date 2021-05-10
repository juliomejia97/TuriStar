package com.webDevelopment.turistar.Shared.Domain.Tour;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TourBookedEventDomain extends DomainEvent {
    private String tourBookingId;
    private LocalDate tourBookingInitDate;
    private LocalDate tourBookingEndDate;
    private Boolean tourBookingActive;


    private TourBookedEventDomain(){
        this.tourBookingId = "";
        this.tourBookingInitDate = null;
        this.tourBookingEndDate = null;
        this.tourBookingActive = false;
    }

    public TourBookedEventDomain(String aggregateId, String eventId, String occurredOn,
                                 String tourBookingId, LocalDate tourBookingInitDate,
                                 LocalDate tourBookingEndDate, Boolean tourBookingActive) {
        super(aggregateId, eventId, occurredOn);
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
        this.tourBookingActive = tourBookingActive;
    }

    public TourBookedEventDomain(String aggregateId,  String tourBookingId, LocalDate tourBookingInitDate, LocalDate tourBookingEndDate,
                                 Boolean tourBookingActive) {
        super(aggregateId);
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
        this.tourBookingActive = tourBookingActive;
    }

    @Override
    public String eventName() {
        return "tourBooking.booked";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("tourBookingId",tourBookingId);
            put("tourBookingInitDate",tourBookingInitDate);
            put("tourBookingEndDate",tourBookingEndDate);
            put("tourBookingActive",tourBookingActive);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TourBookedEventDomain(aggregateId, eventId, occurredOn,
                (String) body.get("tourBookingId"),
                (LocalDate)body.get("tourBookingInitDate"),
                (LocalDate)body.get("tourBookingEndDate"),
                (Boolean)body.get("tourBookingActive"));
    }

    public String getTourBookingId() {
        return tourBookingId;
    }

    public LocalDate getTourBookingInitDate() {
        return tourBookingInitDate;
    }

    public LocalDate getTourBookingEndDate() {
        return tourBookingEndDate;
    }

    public Boolean getTourBookingActive() {
        return tourBookingActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourBookedEventDomain that = (TourBookedEventDomain) o;
        return Objects.equals(tourBookingId, that.tourBookingId) && Objects.equals(tourBookingInitDate, that.tourBookingInitDate) && Objects.equals(tourBookingEndDate, that.tourBookingEndDate) && Objects.equals(tourBookingActive, that.tourBookingActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourBookingId, tourBookingInitDate, tourBookingEndDate, tourBookingActive);
    }
}
