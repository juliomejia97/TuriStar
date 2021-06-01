package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class HotelPlanActive extends BooleanValueObject {
    public HotelPlanActive() {
    }

    public HotelPlanActive(Boolean isActive){
        this.value = isActive;
    }
}
