package com.webDevelopment.turistar.Tour.TourBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class TourBookingActive extends BooleanValueObject {

    public TourBookingActive(boolean active){
        this.value = active;
    }
}
