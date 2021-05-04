package com.webDevelopment.turistar.Hotel.Ticket.Application.All;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TicketsAllResponse {

    private List<Ticket> tickets;

    public TicketsAllResponse(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<HashMap<String,String> > response()
    {
       return tickets.stream().map(Ticket::data).collect(Collectors.toList());
    }
}
