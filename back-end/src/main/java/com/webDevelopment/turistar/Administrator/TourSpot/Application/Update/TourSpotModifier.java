package com.webDevelopment.turistar.Administrator.TourSpot.Application.Update;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects.LatLangInfo;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.List;
import java.util.Optional;

public class TourSpotModifier {

    private TourSpotRepository tourSpotRepository;
    private LatLangInfo latLangInfo;
    private GeoCodeInfoService service;
    private EventBus eventBus;
    public TourSpotModifier(TourSpotRepository tourSpotRepository, GeoCodeInfoService service, EventBus eventBus) {
        this.tourSpotRepository = tourSpotRepository;
        this.service = service;
        this.latLangInfo = new LatLangInfo(service);
        this.eventBus = eventBus;
    }

    public void execute(String tourId, String tourName, String cityName, String cityDescription) throws TourSpotNotExists {
        Optional<TourSpot> tourUpdated = tourSpotRepository.find(tourId);
        if(tourUpdated.isEmpty()){
            throw new TourSpotNotExists("The Tour Spot not exists");
        }
        TourSpot tourSpotToUpdate = tourUpdated.get();
        List<Double> latlong = latLangInfo.execute(tourName,cityName);
        tourSpotToUpdate.updateTour(tourName,latlong.get(0),latlong.get(1), cityDescription);
        this.tourSpotRepository.update(tourSpotToUpdate);
        eventBus.publish(tourSpotToUpdate.pullDomainEvents());
    }
}
