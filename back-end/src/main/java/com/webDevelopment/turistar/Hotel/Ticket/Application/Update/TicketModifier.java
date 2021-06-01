package com.webDevelopment.turistar.Hotel.Ticket.Application.Update;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.TicketsNotExist;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;

import java.time.LocalDate;
import java.util.Optional;

public class TicketModifier {

    private TicketRepository ticketRepository;

    public TicketModifier(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void execute(String ticketId,String hotelPlanBookingId, String airlineName, String ticketDeparture, String ticketDestination, double ticketPrice, LocalDate ticketDateDeparture,LocalDate ticketDateReturn ) throws TicketsNotExist {
        Optional<Ticket> ticketUpdated = ticketRepository.find(ticketId);
        if(ticketUpdated.isEmpty()){
            throw new TicketsNotExist("The ticket not exist");
        }
        Ticket ticketToUpdate = ticketUpdated.get();
        ticketToUpdate.updateTicket( airlineName,   ticketDeparture,   ticketDestination,   ticketPrice,ticketDateReturn,ticketDateDeparture);
        this.ticketRepository.update(ticketToUpdate);
    }
}
