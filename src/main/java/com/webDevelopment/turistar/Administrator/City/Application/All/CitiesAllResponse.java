package com.webDevelopment.turistar.Administrator.City.Application.All;

import com.webDevelopment.turistar.Administrator.City.Domain.City;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CitiesAllResponse {

    private List<City> cities;

    public CitiesAllResponse(List<City> products) {
        this.cities = products;
    }

    public List<HashMap<String, Object>> response()
    {
       return cities.stream().map(City::data).collect(Collectors.toList());
    }
}
