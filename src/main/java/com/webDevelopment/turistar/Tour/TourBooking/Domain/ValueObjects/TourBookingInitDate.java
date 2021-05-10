package com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.DateValueObject;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions.InvalidInitDate;

import java.time.LocalDate;

public class TourBookingInitDate extends DateValueObject {
    public TourBookingInitDate(LocalDate date){
        this.validate(date);
        this.value = date;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidInitDate("The departure date is previous than the current date");
        }
    }

    private TourBookingInitDate(){}
}
