package com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidInitDate;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;

import java.time.LocalDate;

public class TicketDateDeparture extends DateValueObject {

    public TicketDateDeparture() {
    }

    public TicketDateDeparture(LocalDate ticketDateDeparture){
        this.validate(ticketDateDeparture);
        this.value = ticketDateDeparture;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidInitDate("The departure date is previous than the current date");
        }
    }
}
