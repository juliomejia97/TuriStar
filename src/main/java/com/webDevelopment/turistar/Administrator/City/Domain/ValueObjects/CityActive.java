package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class CityActive extends BooleanValueObject {
    public CityActive(Boolean isActive){
        this.value = isActive;
    }
}
