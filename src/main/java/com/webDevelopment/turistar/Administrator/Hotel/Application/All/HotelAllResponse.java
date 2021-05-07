package com.webDevelopment.turistar.Administrator.Hotel.Application.All;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Shared.Application.Response;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HotelAllResponse{

    private List<Hotel> hotels;

    public HotelAllResponse(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<HashMap<String, Object>> response() {
        return hotels.stream().map(Hotel::data).collect(Collectors.toList());
    }
}
