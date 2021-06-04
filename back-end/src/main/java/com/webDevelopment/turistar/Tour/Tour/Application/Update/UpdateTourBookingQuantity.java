package com.webDevelopment.turistar.Tour.Tour.Application.Update;

import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourNotFound;
import com.webDevelopment.turistar.Tour.Tour.Domain.Ports.TourRepository;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.Optional;

public class UpdateTourBookingQuantity {
    public TourRepository repository;

    public UpdateTourBookingQuantity(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId) {
        Optional<Tour> tourOptional = repository.find(aggregateId);
        if(tourOptional.isEmpty()){
            throw new TourNotFound("The tour does not exists");
        }
        Tour tour = tourOptional.get();
        tour.updateQuantity();
        repository.update(tour);
    }
}
