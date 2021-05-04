package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.DoubleValueObject;

public class TourSpotLatitude extends DoubleValueObject {
    public TourSpotLatitude(Double latitude) {
        this.value = latitude;
    }
    private TourSpotLatitude(){

    }
}
