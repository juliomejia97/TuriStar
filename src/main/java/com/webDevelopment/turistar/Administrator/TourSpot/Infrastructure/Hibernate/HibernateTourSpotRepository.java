package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;

import java.util.List;
import java.util.Optional;

public class HibernateTourSpotRepository implements TourSpotRepository {
    @Override
    public void update(TourSpot tourSpot) {

    }

    @Override
    public Optional<TourSpot> find(String tourId) {
        return Optional.empty();
    }

    @Override
    public void save(TourSpot tourSpot) {

    }

    @Override
    public Optional<List<TourSpot>> all() {
        return Optional.empty();
    }
}
