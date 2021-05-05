package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class CityCountry extends StringValueObject {

    public CityCountry(String name){
        this.value = name;
    }

    private CityCountry() {
    }
}
