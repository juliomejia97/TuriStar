package com.webDevelopment.turistar.Administrator.City.Domain.Ports;

import com.webDevelopment.turistar.Administrator.City.Domain.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    void update(City product);
    Optional<City> find(String CityId);
    void save(City product);
    Optional<List<City>> all();
}
