package com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class TourName extends StringValueObject {

    private TourName(){}

    public TourName(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
        if( name.length() < 1 ){
            throw new LengthNotValid("Number of characters invalid");
        }
    }
}
