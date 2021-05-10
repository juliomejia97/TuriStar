package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidInitDate;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;

import java.time.LocalDate;

public class HotelPlanBookingInitDate extends DateValueObject {

    private HotelPlanBookingInitDate(){}

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
