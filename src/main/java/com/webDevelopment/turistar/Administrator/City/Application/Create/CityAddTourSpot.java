package com.webDevelopment.turistar.Administrator.City.Application.Create;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.Optional;

public class CityAddTourSpot {

    private CityRepository repository;

    public CityAddTourSpot(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId, String idTourSpot, String tourSpotName, Double latitude, Double longitude, String description) {
        Optional<City> cityOptional = repository.find(aggregateId);
        if(cityOptional.isEmpty()){
            throw new CityNotExist("The City which of the Tour Spot Created has not been created yet, talk with the admin of the DB");
            //TODO: Hacer un rollback (eventos?)
        }
        City finalCity = cityOptional.get();
        finalCity.addTourSpots(tourSpotName,idTourSpot,description,latitude,longitude);
        repository.update(finalCity);
    }
}
