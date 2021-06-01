package com.webDevelopment.turistar.Tour.Tour.Application.Find;

import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourNotFound;
import com.webDevelopment.turistar.Tour.Tour.Domain.Ports.TourRepository;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.Optional;

public class TourFinder {

    private TourRepository repository;

    public TourFinder(TourRepository repository) {
        this.repository = repository;
    }

    public TourFinderResponse execute(String id)
    {
        Optional<Tour> result = repository.find(new TourId(id).value());
        if (result.isEmpty())
        {
            throw new TourNotFound("The tour with id: " + id + " doesn't exist");
        }
        Tour tour = result.get();
        return new TourFinderResponse(tour);
    }
}
