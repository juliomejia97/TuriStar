package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidEndDate;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;

import java.time.LocalDate;

public class HotelPlanBookingEndDate extends DateValueObject {

    private HotelPlanBookingEndDate(){}

    public HotelPlanBookingEndDate(LocalDate hotelPlanBookingEndDate){
        this.validate(hotelPlanBookingEndDate);
        this.value = hotelPlanBookingEndDate;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidEndDate("The departure date is previous than the current date");
        }
    }
}
