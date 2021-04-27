package com.webDevelopment.turistar.Administrator.City.Application.Update;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.Optional;

public class CityModifier {

    //TODO: Inyectar dependencia
    private CityRepository cityRepository;

    public CityModifier(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void execute(String cityId, String cityName, String cityCountry) throws CitiesNotExist {
        Optional<City> cityUpdated = cityRepository.find(cityId);
        if(cityUpdated.isEmpty()){
            throw new CitiesNotExist("The city not exist");
        }
        City cityToUpdate = cityUpdated.get();
        cityToUpdate.updateCity(cityName,cityCountry);
        this.cityRepository.save(cityToUpdate);

    }
}
