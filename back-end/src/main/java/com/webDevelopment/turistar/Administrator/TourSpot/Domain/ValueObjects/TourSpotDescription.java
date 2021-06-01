package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourDescriptionNotValid;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class TourSpotDescription extends StringValueObject {
    public TourSpotDescription(String description) {
        this.validate(description);
        this.value=description;

    }

    private TourSpotDescription() {
    }

    private void validate(String description){
        if(description.length()< 1 || description.length() >200){
            throw new TourDescriptionNotValid("The description is empty or greather tnan 200 characters");
        }
    }
}
