package com.webDevelopment.turistar.Administrator.TourSpot.Application.Create;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotDuplicated;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TourSpotCreator {
    private TourSpotRepository tourSpotRepository;
    private LatLangInfo latLangInfo;
    private GeoCodeInfoService service;
    private EventBus eventBus;

    public TourSpotCreator(TourSpotRepository tourSpotRepository, GeoCodeInfoService service, EventBus eventBus) {
        this.tourSpotRepository = tourSpotRepository;
        this.service = service;
        this.latLangInfo = new LatLangInfo(service);
        this.eventBus = eventBus;
    }

    public void execute(String tourSpotId, String cityId,String tourSpotName,
                        String cityName, String cityDescription, List<String> photos) throws TourSpotNotExists {
        Optional<TourSpot> tourDuplicated = tourSpotRepository.find(tourSpotId);
        if(tourDuplicated.isPresent()){
            throw new TourSpotDuplicated("The Tour Spot already exists");
        }
        List<Double> latlong = latLangInfo.execute(tourSpotName,cityName);
        List<TourSpotPhoto> tourSpotPhotos = photos.stream().map(TourSpotPhoto::new).collect(Collectors.toList());
        TourSpot tourSpot = TourSpot.create(new TourSpotId(tourSpotId), new CityId(cityId),new TourSpotName(tourSpotName),
                new TourSpotLatitude(latlong.get(0)), new TourSpotLongitude(latlong.get(1)),
                new TourSpotDescription(cityDescription), tourSpotPhotos);
        tourSpotRepository.save(tourSpot);
        eventBus.publish(tourSpot.pullDomainEvents());
    }
}
