package com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelRepository {

    void update(Hotel hotel);
    Optional<Hotel> find(String hotelId);
    void save (Hotel hotel);
    Optional<List<Hotel>> all();

}
