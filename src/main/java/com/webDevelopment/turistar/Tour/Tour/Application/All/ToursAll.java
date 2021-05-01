package com.webDevelopment.turistar.Tour.Tour.Application.All;

import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourNotFound;
import com.webDevelopment.turistar.Tour.Tour.Domain.Ports.TourRepository;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.List;
import java.util.Optional;

public class ToursAll {
    private TourRepository tourRepository;

    public ToursAll(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }

    public List<Tour> execute() {
        Optional<List<Tour>> tours = tourRepository.all();
        if(tours.isEmpty()){
            throw new TourNotFound("There are no tours in the database, contact your admin");
        }
        //TODO: Get only active cities
        return tours.get();
    }
}
