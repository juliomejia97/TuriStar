package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelAddress;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelName;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelStars;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryHotelRepository implements HotelRepository {
    private List<Hotel> hotels = new ArrayList<>(){{
        add(Hotel.create(new HotelId("09905284-af61-11eb-8529-0242ac130003"), new CityId("d0218474-ae97-11eb-8529-0242ac130003"),
                new HotelName("Hotel Irotama"), new HotelStars(4.5d), new HotelAddress("Irotama Resort Km")
        , new ArrayList<>(){{
            add(new HotelPhoto(1,"https://s16847.pcdn.co/wp-content/uploads/2019/09/Galeria1.jpg"));
            add(new HotelPhoto(2,"https://cf.bstatic.com/images/hotel/max1024x768/253/253797511.jpg"));
        }}));
    }};
    @Override
    public void update(Hotel hotel) {
        this.hotels.remove(hotel);
        this.hotels.add(hotel);
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
        return Optional.ofNullable(hotels);
    }
}
