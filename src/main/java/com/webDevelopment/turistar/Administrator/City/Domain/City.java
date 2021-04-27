package com.webDevelopment.turistar.Administrator.City.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;

import java.util.HashMap;
import java.util.Objects;

public class City {

    private CityId cityId;
    private CityName cityName;
    private CityCountry cityCountry;

    private City(){}

    public City(CityId cityId, CityName cityName, CityCountry cityCountry) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId) &&
                Objects.equals(cityCountry, city.cityCountry) &&
                Objects.equals(cityName, city.cityName) ;
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<>() {{
            put("id", cityId.value());
            put("name", cityName.value());
            put("country", cityCountry.value());
        }};
        return data;
    }

    public void updateCity(String cityName,  String cityCountry){
        this.cityName = new CityName(cityName);
        this.cityCountry = new CityCountry(cityCountry);
    }

    public boolean equalsbyId(String cityId){
        return this.cityId.equals(new CityId(cityId));
    }

}
