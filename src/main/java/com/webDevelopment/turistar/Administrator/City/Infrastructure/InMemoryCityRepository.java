package com.webDevelopment.turistar.Administrator.City.Infrastructure;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryCityRepository implements CityRepository {
    @Override
    public void update(City product) {

    }

    @Override
    public Optional<City> find(String CityId) {
        return Optional.empty();
    }

    @Override
    public void save(City product) {

    }

    @Override
    public Optional<List<City>> all() {
        return Optional.empty();
    }
}
