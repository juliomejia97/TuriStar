package com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions;

public class TicketsNotExist extends RuntimeException {
    public TicketsNotExist(String message) {
        super(message);
    }
}
