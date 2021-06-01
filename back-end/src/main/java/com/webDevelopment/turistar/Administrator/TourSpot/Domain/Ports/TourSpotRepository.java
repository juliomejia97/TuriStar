package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;

import java.util.List;
import java.util.Optional;

public interface TourSpotRepository {
    void update(TourSpot tourSpot);
    Optional<TourSpot> find(String tourId);
    void save (TourSpot tourSpot);
    Optional<List<TourSpot>> all();
}
