package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TicketDetail {
    private String ticketDetailId;
    private String hotelPlanBookingId;

    private String ticketAirline;
    private String ticketDeparture;
    private String ticketDestination;
    private double ticketPrice;
    private LocalDate ticketDateDeparture;
    private LocalDate ticketDateReturn;
    private boolean ticketActive;


    public TicketDetail(String ticketDetailId, String hotelPlanBookingId, String ticketAirline,
                        String ticketDeparture, String ticketDestination, double ticketPrice,
                        LocalDate ticketDateDeparture, LocalDate ticketDateReturn, boolean ticketActive) {
        this.ticketDetailId = ticketDetailId;
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.ticketAirline = ticketAirline;
        this.ticketDeparture = ticketDeparture;
        this.ticketDestination = ticketDestination;
        this.ticketPrice = ticketPrice;
        this.ticketDateDeparture = ticketDateDeparture;
        this.ticketDateReturn = ticketDateReturn;
        this.ticketActive = ticketActive;
    }

    private TicketDetail() {
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", ticketDetailId);
            put("airlineName", ticketAirline);
            put("ticketDeparture", ticketDeparture);
            put("ticketDestiantion", ticketDestination);
            put("ticketPrice", ticketPrice);
            put("ticketDateDeparture", ticketDateDeparture.toString());
            put("hotelPlanBookingId", hotelPlanBookingId.toString());
            put("ticketDateReturn", ticketDateReturn.toString());
            put("ticketActive", ticketActive);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDetail ticket = (TicketDetail) o;
        return Objects.equals(ticketDetailId, ticket.ticketDetailId) &&
                Objects.equals(ticketDeparture, ticket.ticketDeparture) &&
                Objects.equals(ticketDestination, ticket.ticketDestination) &&
                Objects.equals(ticketAirline, ticket.ticketAirline) &&
                Objects.equals(ticketPrice, ticket.ticketPrice) &&
                Objects.equals(ticketDateDeparture, ticket.ticketDateDeparture) &&
                Objects.equals(hotelPlanBookingId, ticket.hotelPlanBookingId) &&
                Objects.equals(ticketDateReturn, ticket.ticketDateReturn) &&
                Objects.equals(ticketActive, ticket.ticketActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash( ticketDetailId,  hotelPlanBookingId,  ticketAirline,  ticketDeparture,  ticketDestination,  ticketPrice,  ticketDateDeparture,  ticketDateReturn,  ticketActive);
    }

}
