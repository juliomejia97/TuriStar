package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class TourSpotLongitude extends DoubleValueObject {
    public TourSpotLongitude(Double longitude) {
        this.value = longitude;
    }
    private TourSpotLongitude(){

    }
}
