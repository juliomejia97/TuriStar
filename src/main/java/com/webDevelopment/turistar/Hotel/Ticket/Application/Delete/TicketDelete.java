package com.webDevelopment.turistar.Hotel.Ticket.Application.Delete;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.TicketsNotExist;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;

import java.util.Optional;

public class TicketDelete {
    private TicketRepository ticketRepository;

    public TicketDelete(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public void execute(String ticketId) throws TicketsNotExist {
        Optional<Ticket> ticketUpdated = ticketRepository.find(ticketId);
        if(ticketUpdated.isEmpty()){
            throw new TicketsNotExist("The ticket not exist");
        }
        Ticket ticketToUpdate = ticketUpdated.get();
        ticketToUpdate.deleteTicket();
        this.ticketRepository.update(ticketToUpdate);
    }
}
