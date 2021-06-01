package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BooleanValueObject;

public class TourSpotActive extends BooleanValueObject {
    public TourSpotActive(Boolean isActive) {
        this.value=isActive;
    }
    private TourSpotActive() {
    }
}
