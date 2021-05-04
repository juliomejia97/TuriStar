package com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions;

public class LengthNotValid extends RuntimeException {
    public LengthNotValid(String message) {
        super(message);
    }
}
