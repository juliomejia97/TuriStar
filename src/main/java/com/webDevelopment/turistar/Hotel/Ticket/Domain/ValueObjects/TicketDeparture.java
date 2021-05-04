package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;

public class TicketDeparture extends StringValueObject {

    public TicketDeparture(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
        if( name.length() < 1 ){
            throw new LengthNotValid("Number of characters invalid");
        }
    }

}
