package com.webDevelopment.turistar.Hotel.Ticket.Application.All;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.TicketsNotExist;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketsAll {

    private TicketRepository ticketRepository;

    public TicketsAll(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> execute() {
        Optional<List<Ticket>> tickets = ticketRepository.all();
        if(tickets.isEmpty()){
            throw new TicketsNotExist("There are no tickets in the database, contact your admin");
        }
        //TODO: Get only active cities
        return tickets.get();
    }
}
