package com.webDevelopment.turistar.Administrator.City.Application.Update;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.Optional;

public class UpdateTourSpot {

    private CityRepository repository;

    public UpdateTourSpot(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId, String tourSpotName, Double latitude, Double longitude, String description) {
        Optional<City> cityOptional = repository.find(aggregateId);
        if(cityOptional.isEmpty()){
            throw new CityNotExist("The City which of the Tour Spot Created has not been created yet, talk with the admin of the DB");
            //TODO: Hacer un rollback (eventos?)
        }
        City finalCity = cityOptional.get();
        finalCity.addTourSpots(tourSpotName, description,latitude,longitude);
        repository.update(finalCity);
    }
}
