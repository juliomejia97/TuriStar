package com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    void update(String ticketId, Ticket ticket);
    Optional<Ticket> find(String ticketId);
    void save(Ticket ticket);
    Optional<List<Ticket>> all();
}
