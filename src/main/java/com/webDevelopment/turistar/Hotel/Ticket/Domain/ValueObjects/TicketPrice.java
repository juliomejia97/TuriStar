package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;

import java.util.Objects;

public class TicketPrice {
    private Double value;
    public TicketPrice(Double ticketPrice){
        this.validate(ticketPrice);
        value = ticketPrice;
        System.out.println(value);
    }

    private void validate(double ticketPrice){
        if( ticketPrice < 0 ){
            throw new LengthNotValid("Negative price");
        }
    }
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPrice that = (TicketPrice) o;
        return Objects.equals(value, that.value);
    }
}
