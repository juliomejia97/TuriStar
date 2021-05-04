package com.webDevelopment.turistar.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class HotelPlanActive extends BooleanValueObject {
    public HotelPlanActive(Boolean isActive){
        this.value = isActive;
    }
}
