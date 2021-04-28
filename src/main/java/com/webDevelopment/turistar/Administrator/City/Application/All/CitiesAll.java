package com.webDevelopment.turistar.Administrator.City.Application.All;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.List;
import java.util.Optional;

public class CitiesAll {

    private CityRepository cityRepository;

    public CitiesAll(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> execute() {
        Optional<List<City>> cities = cityRepository.all();
        if(cities.isEmpty()){
            throw new CitiesNotExist("There are no cities in the database, contact your admin");
        }
        //TODO: Get only active cities
        return cities.get();
    }
}
