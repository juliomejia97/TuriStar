package com.webDevelopment.turistar.Administrator.City.Application.Find;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Shared.Application.Response;

import java.util.HashMap;

public class CityFinderResponse implements Response {
    private final City city;
    private HashMap<String, Object> response;

    public CityFinderResponse(City city) {
        this.city = city;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = city.data();
        return response;
    }
}
