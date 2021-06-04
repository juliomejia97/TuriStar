package com.webDevelopment.turistar.Administrator.City.Application.Update;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CityUpdateHotel {
    private CityRepository repository;

    public CityUpdateHotel(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String aggregateId, String hotelId, String hotelName, Double hotelStars,
                        String hotelAddress, List<String> hotelPhotos) {
        Optional<City> cityOptional = repository.find(aggregateId);
        if(cityOptional.isEmpty()){
            throw new CityNotExist("The City of the updated Hotel does not exists, please talk with the admin");
        }
        City finalCity = cityOptional.get();
        finalCity.updateHotelDetail(hotelId,hotelName,hotelAddress,hotelStars,hotelPhotos);
        repository.update(finalCity);
    }
}
