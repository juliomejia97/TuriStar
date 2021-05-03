package com.webDevelopment.turistar.Administrator.City.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityAlreadyDeleted;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityActive;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;

import java.util.HashMap;
import java.util.Objects;

public class City {

    private CityId cityId;
    private CityName cityName;
    private CityCountry cityCountry;
    private CityActive cityActive;


    private City(){}

    public City(CityId cityId, CityName cityName, CityCountry cityCountry) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.cityActive= new CityActive(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId) &&
                Objects.equals(cityCountry, city.cityCountry) &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityActive, city.cityActive);
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<>() {{
            put("id", cityId.value());
            put("name", cityName.value());
            put("country", cityCountry.value());
            put("cityActive", cityActive.value().toString());
        }};
        return data;
    }

    public void updateCity(String cityName,  String cityCountry){
        this.cityName = new CityName(cityName);
        this.cityCountry = new CityCountry(cityCountry);
    }

    public void deleteCity(){
        if(!this.cityActive.value()){
            throw new CityAlreadyDeleted("The city has been already deleted");
        }
        this.cityActive = new CityActive(false);
    }
    public boolean equalsbyId(String cityId){
        return this.cityId.equals(new CityId(cityId));
    }

}
