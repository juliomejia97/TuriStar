package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;

public class TicketPrice {
    private double value;
    public TicketPrice(Double ticketPrice){
        this.validate(ticketPrice);
        value = ticketPrice;
    }

    private void validate(double ticketPrice){
        if( ticketPrice < 0 ){
            throw new LengthNotValid("Negative price");
        }
    }
}
