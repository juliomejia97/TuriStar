package com.webDevelopment.turistar.Administrator.City.Domain.Ports;

import com.webDevelopment.turistar.Administrator.City.Domain.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    Optional<City> find(String cityId);
    Optional<List<City>> all();
}
