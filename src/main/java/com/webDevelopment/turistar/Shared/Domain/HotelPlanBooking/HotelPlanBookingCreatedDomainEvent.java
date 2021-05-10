package com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class HotelPlanBookingCreatedDomainEvent extends DomainEvent
{
    private String hotelPlanBookingId;
    private LocalDate hotelPlanBookingInitDate;
    private LocalDate hotelPlanBookingEndDate;


    private HotelPlanBookingCreatedDomainEvent() {
        this.hotelPlanBookingId = null;
        this.hotelPlanBookingInitDate = null;
        this.hotelPlanBookingEndDate = null;
    }

    public HotelPlanBookingCreatedDomainEvent(String aggregateId, String hotelPlanBookingId, LocalDate hotelPlanBookingInitDate, LocalDate hotelPlanBookingEndDate) {
        super(aggregateId);
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
    }

    public HotelPlanBookingCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String hotelPlanBookingId, LocalDate hotelPlanBookingInitDate, LocalDate hotelPlanBookingEndDate) {
        super(aggregateId, eventId, occurredOn);
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
    }

    @Override
    public String eventName() {
        return "hotelPlanBooking.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("hotelPlanBookingId",hotelPlanBookingId);
            put("hotelPlanBookingInitDate",hotelPlanBookingInitDate);
            put("hotelPlanBookingEndDate",hotelPlanBookingEndDate);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new HotelPlanBookingCreatedDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("hotelPlanBookingId"),
                (LocalDate)body.get("hotelPlanBookingInitDate"),
                (LocalDate)body.get("hotelPlanBookingEndDate"));
    }

    public String getHotelPlanBookingId() {
        return hotelPlanBookingId;
    }

    public LocalDate getHotelPlanBookingInitDate() {
        return hotelPlanBookingInitDate;
    }

    public LocalDate getHotelPlanBookingEndDate() {
        return hotelPlanBookingEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPlanBookingCreatedDomainEvent that = (HotelPlanBookingCreatedDomainEvent) o;
        return Objects.equals(hotelPlanBookingId, that.hotelPlanBookingId) && Objects.equals(hotelPlanBookingInitDate, that.hotelPlanBookingInitDate) && Objects.equals(hotelPlanBookingEndDate, that.hotelPlanBookingEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelPlanBookingId, hotelPlanBookingInitDate, hotelPlanBookingEndDate);
    }
}