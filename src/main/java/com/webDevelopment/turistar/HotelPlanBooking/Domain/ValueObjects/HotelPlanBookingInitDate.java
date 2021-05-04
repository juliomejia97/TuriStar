package com.webDevelopment.turistar.HotelPlanBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketPrice;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions.InvalidInitDate;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class HotelPlanBookingInitDate extends DateValueObject {
    public HotelPlanBookingInitDate(LocalDate hotelPlanBookingInitDate){
        this.validate(hotelPlanBookingInitDate);
        this.value = hotelPlanBookingInitDate;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidInitDate("The departure date is previous than the current date");
        }
    }

}
