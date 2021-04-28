package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class CityCountry extends StringValueObject {

    public CityCountry(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name){
        if( name.length() < 1 ){
            throw new LengthNotValid("Number of characters invalid");
        }
    }

}
