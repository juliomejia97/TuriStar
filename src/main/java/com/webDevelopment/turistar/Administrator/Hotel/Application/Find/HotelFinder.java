package com.webDevelopment.turistar.Administrator.Hotel.Application.Find;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelNotExists;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;

import java.util.Optional;

public class HotelFinder {
    private HotelRepository repository;

    public HotelFinder(HotelRepository repository) {
        this.repository = repository;
    }

    public HotelResponse execute(String idHotel) throws HotelNotExists{
        Optional<Hotel> hotelOptional = repository.find(idHotel);
        if(hotelOptional.isEmpty()){
            throw new HotelNotExists("The hotel that you are looking for, does not exists");
        }
        return new HotelResponse(hotelOptional.get());
    }
}
