package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class TicketActive extends BooleanValueObject {
    public TicketActive(Boolean isActive){
        this.value = isActive;
    }
}
