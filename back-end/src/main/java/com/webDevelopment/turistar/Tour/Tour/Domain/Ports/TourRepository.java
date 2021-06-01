package com.webDevelopment.turistar.Tour.Tour.Domain.Ports;

import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository {
    void update(Tour tour);
    Optional<Tour> find(String tourId);
    void save(Tour tour);
    Optional<List<Tour>> all();
}
