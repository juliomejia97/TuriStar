package com.webDevelopment.turistar.Administrator.City.Application.Update;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityValidateInfo;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.Optional;

public class CityModifier {

    private CityRepository cityRepository;
    private CityValidateInfo validator;
    private GeoCodeInfoService service;

    public CityModifier(CityRepository cityRepository, GeoCodeInfoService service) {
        this.cityRepository = cityRepository;
        this.service = service;
        this.validator = new CityValidateInfo(service);
    }

    public void execute(String cityId, String cityName, String cityCountry) throws CitiesNotExist {
        Optional<City> cityUpdated = cityRepository.find(cityId);
        if(cityUpdated.isEmpty()){
            throw new CitiesNotExist("The city not exist");
        }
        City cityToUpdate = cityUpdated.get();
        cityToUpdate.updateCity(cityName,cityCountry);
        validator.execute(cityName,cityCountry);
        this.cityRepository.update(cityToUpdate);
    }

}
