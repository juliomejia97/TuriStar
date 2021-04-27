package com.webDevelopment.turistar.Administrator.City.Infrastructure;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCityRepository implements CityRepository {

    private City city1 = new City(new CityId("a0619482-a621-11eb-bcbc-0242ac130002"), new CityName("Bogotá"),new CityCountry("Colombia"));
    private City city2 = new City(new CityId("a06197e8-a621-11eb-bcbc-0242ac130002"), new CityName("Medellín"),new CityCountry("Colombia"));
    private City city3 = new City(new CityId("a06198e2-a621-11eb-bcbc-0242ac130002"), new CityName("Bucaramanga"),new CityCountry("Colombia"));
    private List<City> cites = new ArrayList<>(){{
        add(city1);
        add(city2);
        add(city3);
    }};

    @Override
    public void update(City city) {
        Optional<City> cityToupdate = this.cites.stream().filter(c -> c.equalsbyId(city)).findFirst();
        cityToupdate.ifPresent(value -> this.cites.remove(value));
        this.cites.add(city);
    }

    @Override
    public Optional<City> find(String cityId) {
        return cites.stream().filter(city -> city.equalsbyId(cityId)).findFirst();
    }

    @Override
    public void save(City city) {
        this.cites.add(city);
    }

    @Override
    public Optional<List<City>> all() {
        return Optional.ofNullable(this.cites);
    }
}
