package com.webDevelopment.turistar.Administrator.Hotel.Domain;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelAddress;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelName;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhotos;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelStars;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;

import java.util.HashMap;
import java.util.Objects;

public class Hotel {
    private HotelId hotelId;
    private CityId cityId;
    private HotelName hotelName;
    private HotelStars hotelStars;
    private HotelAddress hotelAddress;
    private HotelPhotos hotelPhotos;

    public Hotel(HotelId hotelId, CityId cityId, HotelName hotelName, HotelStars hotelStars, HotelAddress hotelAddress, HotelPhotos hotelPhotos) {
        this.hotelId = hotelId;
        this.cityId = cityId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }

    private Hotel(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(hotelId,hotel.hotelId) &&
                Objects.equals(cityId,hotel.cityId) &&
                Objects.equals(hotelName,hotel.hotelName) &&
                Objects.equals(hotelStars,hotel.hotelStars) &&
                Objects.equals(hotelAddress,hotel.hotelAddress) &&
                Objects.equals(hotelPhotos,hotel.hotelPhotos);
    }

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<>() {{
            put("id",hotelId);
            put("cityId",cityId);
            put("hotelName",hotelPhotos);
            put("hotelStars",hotelStars);
            put("hotelAddress",hotelAddress);
            put("photos:",hotelPhotos);

        }};
        return data;
    }

    public Boolean equalsById(String hotelId){
        return this.hotelId.equals(new HotelId(hotelId));
    }
}
