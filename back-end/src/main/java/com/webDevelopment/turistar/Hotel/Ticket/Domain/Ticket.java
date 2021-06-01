package com.webDevelopment.turistar.Hotel.Ticket.Domain;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;
import com.webDevelopment.turistar.Shared.Domain.Ticket.TicketId;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class Ticket {

    private TicketId ticketId;
    private HotelPlanBookingId hotelPlanBookingId;
    private TicketAirline ticketAirline;
    private TicketDeparture ticketDeparture;
    private TicketDestination ticketDestination;
    private TicketPrice ticketPrice;
    private TicketDateDeparture ticketDateDeparture;
    private TicketDateReturn ticketDateReturn;
    private TicketActive ticketActive;


    private Ticket(){}

    public Ticket(TicketId ticketId, HotelPlanBookingId hotelPlanBookingId, TicketAirline ticketAirline, TicketDeparture ticketDeparture, TicketDestination ticketDestination,TicketPrice ticketPrice,TicketDateDeparture ticketDateDeparture,TicketDateReturn ticketDateReturn) {
        this.ticketId = ticketId;
        this.ticketAirline = ticketAirline;
        this.ticketDeparture = ticketDeparture;
        this.ticketDestination = ticketDestination;
        this.ticketPrice = ticketPrice;
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.ticketDateDeparture = ticketDateDeparture;
        this.ticketDateReturn = ticketDateReturn;
        this.ticketActive= new TicketActive(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId) &&
                Objects.equals(ticketDeparture, ticket.ticketDeparture) &&
                Objects.equals(ticketDestination, ticket.ticketDestination) &&
                Objects.equals(ticketAirline, ticket.ticketAirline) &&
                Objects.equals(ticketPrice, ticket.ticketPrice) &&
                Objects.equals(ticketDateDeparture, ticket.ticketDateDeparture) &&
                Objects.equals(hotelPlanBookingId, ticket.hotelPlanBookingId) &&
                Objects.equals(ticketDateReturn, ticket.ticketDateReturn) &&
                Objects.equals(ticketActive, ticket.ticketActive);
    }

    public HashMap<String, String> data()
    {
        return new HashMap<>() {{
        put("id", ticketId.value());
        put("airlineName", ticketAirline.value());
        put("ticketDeparture", ticketDeparture.value());
        put("ticketDestiantion", ticketDestination.value());
        put("ticketPrice", ticketPrice.value().toString());
        put("ticketDateDeparture", ticketDateDeparture.value().toString());
        put("hotelPlanBookingId", hotelPlanBookingId.value().toString());
        put("ticketDateReturn", ticketDateReturn.value().toString());
        put("ticketActive", ticketActive.value().toString());
        }};
    }

    public void updateTicket(String airlineName, String ticketDeparture, String ticketDestination, Double ticketPrice, LocalDate ticketDateReturn,LocalDate ticketDateDeparture ){
        this.ticketAirline = new TicketAirline(airlineName);
        this.ticketDeparture = new TicketDeparture(ticketDeparture);
        this.ticketDestination = new TicketDestination(ticketDestination);
        this.ticketPrice = new TicketPrice(ticketPrice);
        this.ticketDateReturn = new TicketDateReturn(ticketDateReturn);
        this.ticketDateDeparture = new TicketDateDeparture(ticketDateDeparture);
    }

    public void deleteTicket(){
        this.ticketActive = new TicketActive(false);
    }

    public boolean equalsbyId(String ticketId){
        return this.ticketId.equals(new TicketId(ticketId));
    }

}
