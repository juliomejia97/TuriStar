package com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;

public class TourSpotDetail {

    private TourSpotId tourSpotId;
    private CityId cityId;
    private TourSpotName tourSpotName;
    private TourSpotLatitude latitude;
    private TourSpotLongitude longitude;
    private TourSpotDescription description;
    private TourSpotActive tourSpotActive;

}
