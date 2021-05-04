package com.webDevelopment.turistar.HotelPlanBooking.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class HotelPlanBookingActive extends BooleanValueObject {
    public HotelPlanBookingActive(Boolean isActive){
        this.value = isActive;
    }
    private HotelPlanBookingActive(){

    }
}
