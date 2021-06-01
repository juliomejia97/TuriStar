package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidEndDate;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;

import java.time.LocalDate;

public class TicketDateReturn extends DateValueObject {

    public TicketDateReturn() {
    }

    public TicketDateReturn(LocalDate ticketDateReturn){
        this.validate(ticketDateReturn);
        this.value = ticketDateReturn;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidEndDate("The return date is previous than the current date");
        }
    }
}
