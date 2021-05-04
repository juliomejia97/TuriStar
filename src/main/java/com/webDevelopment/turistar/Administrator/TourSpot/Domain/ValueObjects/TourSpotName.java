package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNameNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class TourSpotName extends StringValueObject {
    public TourSpotName(String name) {
        this.validate(name);
        this.value=name;
    }

    private TourSpotName() {
    }

    private void validate(String name){
        if(name.length()<1){
            throw new TourSpotNameNotValid("The Tour Spot is empty");
        }
    }
}
