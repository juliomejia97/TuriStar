package com.webDevelopment.turistar.Administrator.Hotel.Application.Find;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Shared.Application.Response;

import java.util.HashMap;

public class HotelResponse implements Response {
    private final Hotel hotel;
    private HashMap<String, Object> response;
    public HotelResponse(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response =  hotel.data();
        return response;
    }
}
