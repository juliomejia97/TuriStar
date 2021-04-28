package com.webDevelopment.turistar.Administrator.City.Domain.Ports;

import com.webDevelopment.turistar.Administrator.City.Domain.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    void update(String cityId,City city);
    Optional<City> find(String CityId);
    void save(City city);
    Optional<List<City>> all();
}
