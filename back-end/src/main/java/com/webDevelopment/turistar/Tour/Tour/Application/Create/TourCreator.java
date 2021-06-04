package com.webDevelopment.turistar.Tour.Tour.Application.Create;

import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import com.webDevelopment.turistar.Tour.Tour.Domain.Exceptions.TourDuplicated;
import com.webDevelopment.turistar.Tour.Tour.Domain.Ports.TourRepository;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourBookings;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourDescription;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourName;
import com.webDevelopment.turistar.Tour.Tour.Domain.ValueObjects.TourPrice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TourCreator {
    private TourRepository tourRepository;

    public TourCreator(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public void execute(String id, String name, String description,
                        Integer bookings, Double price, List<String> tourSpotsId) {
        Optional<Tour> tourOptional = tourRepository.find(id);
        if(tourOptional.isPresent()){
            throw new TourDuplicated("The Tour already existis");
        }
        List<TourSpotId> tourSpotIds = tourSpotsId.stream().map(TourSpotId::new).collect(Collectors.toList());
        Tour tour = Tour.create(new TourId(id),new TourName(name),
                new TourDescription(description), new TourBookings(bookings),
                new TourPrice(price),tourSpotIds);
        tourRepository.save(tour);

    }

}
