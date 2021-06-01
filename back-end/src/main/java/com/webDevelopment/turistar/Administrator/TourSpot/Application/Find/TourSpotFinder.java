package com.webDevelopment.turistar.Administrator.TourSpot.Application.Find;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;

import java.util.Optional;

public class TourSpotFinder {

    private TourSpotRepository repository;

    public TourSpotFinder(TourSpotRepository repository) {
        this.repository = repository;
    }

    public TourSpotResponse execute(String id) {
        Optional<TourSpot> response  = repository.find(id);
        if(response.isEmpty()){
            throw new TourSpotNotExists("The Tour Spot that you are looking for does not exists");
        }
        return new TourSpotResponse(response.get());
    }
}
