package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class CityName extends StringValueObject {

    public CityName(String name){
        this.value = name;
    }

    private CityName() {
    }
}
