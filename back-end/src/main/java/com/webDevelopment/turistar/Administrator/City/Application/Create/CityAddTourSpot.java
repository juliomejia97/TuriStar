package com.webDevelopment.turistar.Administrator.City.Application.Create;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.List;
import java.util.Optional;

public class CityAddTourSpot {

    private CityRepository repository;

    public CityAddTourSpot(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId, String tourSpotId, String tourSpotName, Double latitude, Double longitude, String description, List<String> photos) {
        Optional<City> cityOptional = repository.find(aggregateId);
         if(cityOptional.isEmpty()){
            throw new CityNotExist("The City which of the Tour Spot Created has not been created yet, talk with the admin of the DB");
        }
        City finalCity = cityOptional.get();
        finalCity.addTourSpots(tourSpotName,tourSpotId,description,latitude,longitude,photos);
        repository.update(finalCity);
    }
}
