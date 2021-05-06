package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryHotelRepository implements HotelRepository {
    private List<Hotel> hotels = new ArrayList<>();

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public Optional<Hotel> find(String hotelId) {
        return hotels.stream().filter(hotel -> hotel.equalsById(hotelId)).findFirst();
    }

    @Override
    public void save(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override
    public Optional<List<Hotel>> all() {
        return Optional.empty();
    }
}
