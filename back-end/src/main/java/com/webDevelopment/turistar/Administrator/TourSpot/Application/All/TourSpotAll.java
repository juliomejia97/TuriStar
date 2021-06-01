package com.webDevelopment.turistar.Administrator.TourSpot.Application.All;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotsNotExists;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;

import java.util.List;
import java.util.Optional;

public class TourSpotAll {
    private TourSpotRepository spotRepository;

    public TourSpotAll(TourSpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public List<TourSpot> execute(){
        Optional<List<TourSpot>> tourSpots = spotRepository.all();
        if(tourSpots.isEmpty()){
            throw new TourSpotsNotExists("There are no tour spots in the database, contact your admin");
        }
        return tourSpots.get();
    }
}
