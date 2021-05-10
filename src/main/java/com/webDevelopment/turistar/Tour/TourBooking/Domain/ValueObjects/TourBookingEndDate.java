package com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.DateValueObject;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Exceptions.InvalidEndDate;

import java.time.LocalDate;

public class TourBookingEndDate extends DateValueObject {

    public TourBookingEndDate(LocalDate date){
        this.validate(date);
        this.value = date;
    }

    private void validate(LocalDate date){
        if( date.isBefore( LocalDate.now() ) ){
            throw new InvalidEndDate("The end date is previous than the current date");
        }
    }

    private TourBookingEndDate() {
    }
}
