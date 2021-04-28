package com.webDevelopment.turistar.Administrator.City.Application.Delete;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.List;
import java.util.Optional;

public class CityDelete {
    private CityRepository cityRepository;

    public CityDelete(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public void execute(String cityId) throws CitiesNotExist {
        Optional<City> cityUpdated = cityRepository.find(cityId);
        if(cityUpdated.isEmpty()){
            throw new CitiesNotExist("The city not exist");
        }
        City cityToUpdate = cityUpdated.get();
        cityToUpdate.deleteCity();
        this.cityRepository.update(cityId,cityToUpdate);
    }
}
