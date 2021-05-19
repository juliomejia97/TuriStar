package com.webDevelopment.turistar.Administrator.City.Application.Update;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.Optional;

public class CityUpdateTourSpots {
    private CityRepository cityRepository;

    public CityUpdateTourSpots(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void execute(String aggregateId, String tourSpotId, String tourSpotName, Double latitude, Double longitude, String description) {
        Optional<City> cityOptional = cityRepository.find(aggregateId);
        if(cityOptional.isEmpty()){
            throw new CityNotExist("The City of the Tour Spot does not exists, please talk with the admin");
        }
        City finalCity = cityOptional.get();
        finalCity.updateTourSpotsDetail(tourSpotId,tourSpotName,latitude,longitude,description);
        cityRepository.update(finalCity);
    }
}
