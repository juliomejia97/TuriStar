package com.webDevelopment.turistar.Administrator.City.Application.Create;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.HashMap;
import java.util.Optional;

public class CityAddHotel {

    private CityRepository repository;

    public CityAddHotel(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId, String hotelId, String hotelName, String hotelAddress,
                        Double hotelStars, HashMap<String, Object> hotelPhotos) {
        Optional<City> optionalCity = repository.find(aggregateId);
        if(optionalCity.isEmpty()){
            throw new CityNotExist("The City of the hotel that you have been created does not exists, please contact with your admin");
        }
        City finalCity = optionalCity.get();
        finalCity.addHotel(hotelId,hotelName,hotelAddress,hotelStars,hotelPhotos);
        repository.update(finalCity);
    }
}
