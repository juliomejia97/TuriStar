package com.webDevelopment.turistar.Administrator.Hotel.Application.All;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelsEmpty;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;

import java.util.List;
import java.util.Optional;

public class HotelAll {
    private HotelRepository repository;

    public HotelAll(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> execute() {
        Optional<List<Hotel>> allHotels = repository.all();
        if(allHotels.isEmpty()){
            throw new HotelsEmpty("No hotels are created for the city, you can create it");
        }
        return allHotels.get();
    }
}
