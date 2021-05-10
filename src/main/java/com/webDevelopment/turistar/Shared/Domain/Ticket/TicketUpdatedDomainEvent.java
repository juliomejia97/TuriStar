package com.webDevelopment.turistar.Shared.Domain.Ticket;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingCreatedDomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TicketUpdatedDomainEvent extends DomainEvent {

    private String ticketId;
    private String ticketAirline;
    private String ticketDeparture;
    private String ticketDestination;
    private double ticketPrice;
    private LocalDate ticketDateDeparture;
    private LocalDate ticketDateReturn;
    private boolean ticketActive;

    private TicketUpdatedDomainEvent() {
        this.ticketId =null;
        this.ticketAirline = null;
        this.ticketDeparture = null;
        this.ticketDestination = null;
        this.ticketPrice = 0;
        this.ticketDateDeparture = null;
        this.ticketDateReturn = null;
        this.ticketActive = false;
    }

    public TicketUpdatedDomainEvent(String aggregateId, String ticketId, String ticketAirline, String ticketDeparture, String ticketDestination, double ticketPrice, LocalDate ticketDateDeparture, LocalDate ticketDateReturn, boolean ticketActive) {
        super(aggregateId);
        this.ticketId = ticketId;
        this.ticketAirline = ticketAirline;
        this.ticketDeparture = ticketDeparture;
        this.ticketDestination = ticketDestination;
        this.ticketPrice = ticketPrice;
        this.ticketDateDeparture = ticketDateDeparture;
        this.ticketDateReturn = ticketDateReturn;
        this.ticketActive = ticketActive;
    }

    public TicketUpdatedDomainEvent(String aggregateId, String eventId, String occurredOn, String ticketId, String ticketAirline, String ticketDeparture, String ticketDestination, double ticketPrice, LocalDate ticketDateDeparture, LocalDate ticketDateReturn, boolean ticketActive) {
        super(aggregateId, eventId, occurredOn);
        this.ticketId = ticketId;
        this.ticketAirline = ticketAirline;
        this.ticketDeparture = ticketDeparture;
        this.ticketDestination = ticketDestination;
        this.ticketPrice = ticketPrice;
        this.ticketDateDeparture = ticketDateDeparture;
        this.ticketDateReturn = ticketDateReturn;
        this.ticketActive = ticketActive;
    }



    @Override
    public String eventName() {
        return "Hotel.ticket.updated";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("ticketId",ticketId);
            put("ticketAirline",ticketAirline);
            put("ticketDeparture",ticketDeparture);
            put("ticketDestination",ticketDestination);
            put("ticketPrice",ticketPrice);
            put("ticketDateDeparture",ticketDateDeparture);
            put("ticketDateReturn",ticketDateReturn);
            put("ticketActive",ticketActive);

        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TicketUpdatedDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("ticketId"),
                (String) body.get("ticketAirline"),
                (String) body.get("ticketDeparture"),
                (String) body.get("ticketDestination"),
                (double) body.get("ticketPrice"),
                (LocalDate) body.get("ticketDateDeparture"),
                (LocalDate) body.get("ticketDateReturn"),
                (boolean) body.get("ticketActive"));
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTicketAirline() {
        return ticketAirline;
    }

    public String getTicketDeparture() {
        return ticketDeparture;
    }

    public String getTicketDestination() {
        return ticketDestination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public LocalDate getTicketDateDeparture() {
        return ticketDateDeparture;
    }

    public LocalDate getTicketDateReturn() {
        return ticketDateReturn;
    }

    public boolean isTicketActive() {
        return ticketActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketUpdatedDomainEvent that = (TicketUpdatedDomainEvent) o;
        return Double.compare(that.ticketPrice, ticketPrice) == 0 && ticketActive == that.ticketActive && Objects.equals(ticketId, that.ticketId) && Objects.equals(ticketAirline, that.ticketAirline) && Objects.equals(ticketDeparture, that.ticketDeparture) && Objects.equals(ticketDestination, that.ticketDestination) && Objects.equals(ticketDateDeparture, that.ticketDateDeparture) && Objects.equals(ticketDateReturn, that.ticketDateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, ticketAirline, ticketDeparture, ticketDestination, ticketPrice, ticketDateDeparture, ticketDateReturn, ticketActive);
    }
}
