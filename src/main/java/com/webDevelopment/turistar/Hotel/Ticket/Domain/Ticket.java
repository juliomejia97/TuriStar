package com.webDevelopment.turistar.Hotel.Ticket.Domain;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Ticket.TicketId;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.Objects;

public class Ticket {

    private TicketId ticketId;
    private TicketAirline ticketAirline;
    private TicketDeparture ticketDeparture;
    private TicketDestination ticketDestination;
    private TicketPrice ticketPrice;

    private TicketActive ticketActive;


    private Ticket(){}

    public Ticket(TicketId ticketId, TicketAirline ticketAirline, TicketDeparture ticketDeparture, TicketDestination ticketDestination,TicketPrice ticketPrice) {
        this.ticketId = ticketId;
        this.ticketAirline = ticketAirline;
        this.ticketDeparture = ticketDeparture;
        this.ticketDestination = ticketDestination;
        this.ticketPrice = ticketPrice;
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
        put("ticketActive", ticketActive.value().toString());
    }};
    }

    public void updateTicket(String airlineName,  String ticketDeparture,  String ticketDestination,  Double ticketPrice){
        this.ticketAirline = new TicketAirline(airlineName);
        this.ticketDeparture = new TicketDeparture(ticketDeparture);
        this.ticketDestination = new TicketDestination(ticketDestination);
        this.ticketPrice = new TicketPrice(ticketPrice);
    }

    public void deleteTicket(){
        this.ticketActive = new TicketActive(false);
    }

    public boolean equalsbyId(String ticketId){
        return this.ticketId.equals(new TicketId(ticketId));
    }

}
