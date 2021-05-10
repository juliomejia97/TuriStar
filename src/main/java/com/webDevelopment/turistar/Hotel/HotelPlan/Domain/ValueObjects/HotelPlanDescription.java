package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions.InvalidPeopleNumber;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class HotelPlanDescription extends StringValueObject {

    public HotelPlanDescription() {
    }

    public HotelPlanDescription(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
        if( name.length() < 1 ){
            throw new InvalidPeopleNumber("Number of characters invalid");
        }
    }

}
