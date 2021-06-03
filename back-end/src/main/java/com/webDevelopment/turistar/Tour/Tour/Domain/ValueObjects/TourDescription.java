package com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourDescriptionError;

public class TourDescription extends StringValueObject {
    public TourDescription(String description) {
        this.validate(description);
        this.value = description;
    }
    private void validate(String description){
        if(description.length() < 1 || description.length() > 200){
            throw new TourDescriptionError("The length of the description has to be greater than 1 and less than 200 characters");
        }
    }

    public TourDescription() {
    }
}
