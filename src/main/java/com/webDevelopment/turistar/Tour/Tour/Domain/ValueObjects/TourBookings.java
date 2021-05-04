package com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.IntegerValueObject;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.NegativeNumber;

public class TourBookings extends IntegerValueObject {

    private TourBookings(){}

    public TourBookings(int bookings){
        this.validate(bookings);
        this.value = bookings;
    }

    private void validate(int bookings){
        if( bookings < 0 ){
            throw new NegativeNumber("Number of bookings should be a positive integer");
        }
    }
}
