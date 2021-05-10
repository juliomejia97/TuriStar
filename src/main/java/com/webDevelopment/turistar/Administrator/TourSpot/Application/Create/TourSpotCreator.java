package com.webDevelopment.turistar.Administrator.TourSpot.Application.Create;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotDuplicated;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.List;
import java.util.Optional;

public class TourSpotCreator {
    private TourSpotRepository tourSpotRepository;
    private LatLangInfo latLangInfo;
    private GeoCodeInfoService service;

    public TourSpotCreator(TourSpotRepository tourSpotRepository, GeoCodeInfoService service) {
        this.tourSpotRepository = tourSpotRepository;
        this.service = service;
        this.latLangInfo = new LatLangInfo(service);
    }

    public void execute(String tourSpotId, String cityId,String tourSpotName, String cityName, String cityDescription, String tourId) throws TourSpotNotExists {
        Optional<TourSpot> tourDuplicated = tourSpotRepository.find(tourSpotId);
        if(tourDuplicated.isPresent()){
            throw new TourSpotDuplicated("The Tour Spot already exists");
        }
        List<Double> latlong = latLangInfo.execute(tourSpotName,cityName);
        TourSpot tourSpot = TourSpot.create(new TourSpotId(tourSpotId), new CityId(cityId),new TourSpotName(tourSpotName),
                new TourSpotLatitude(latlong.get(0)), new TourSpotLongitude(latlong.get(1)),
                new TourSpotDescription(cityDescription), new TourId(tourId) );
        tourSpotRepository.save(tourSpot);
    }
}
