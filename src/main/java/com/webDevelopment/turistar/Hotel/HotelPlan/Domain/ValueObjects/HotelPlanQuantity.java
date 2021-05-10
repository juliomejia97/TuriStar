package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions.InvalidPrice;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions.InvalidQuantity;
import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class HotelPlanQuantity extends DoubleValueObject {
    public HotelPlanQuantity(double quantity){
        this.validate(quantity);
        this.value = quantity;
    }

    private void validate(double quantity){
        if( quantity< 1 ){
            throw new InvalidQuantity("Price less than 0");
        }
    }
}
