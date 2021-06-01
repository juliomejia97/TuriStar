package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

import java.util.Objects;

public class TicketPrice extends DoubleValueObject {
    public TicketPrice() {
    }

    public TicketPrice(Double ticketPrice){
        this.validate(ticketPrice);
        value = ticketPrice;
    }
    private void validate(double ticketPrice){
        if( ticketPrice < 0 ){
            throw new LengthNotValid("Negative price");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPrice that = (TicketPrice) o;
        return Objects.equals(value, that.value);
    }
}
