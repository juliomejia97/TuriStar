package com.webDevelopment.turistar.Administrator.City.Application.Find;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.Optional;

public class CityFinder {
    private CityRepository cityRepository;

    public CityFinder(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public CityFinderResponse execute(String id){
        Optional<City> result = cityRepository.find(id);
        if(result.isEmpty()){
            throw new CityNotExist("The city that you are looking for does not exists");
        }
        City city = result.get();
        return new CityFinderResponse(city);
    }

}
