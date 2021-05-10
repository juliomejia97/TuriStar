package com.webDevelopment.turistar.Administrator.Hotel.Domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelAddress;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelName;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelStars;
import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelCreatedDomainEvent;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Hotel extends AggregateRoot {
    private HotelId hotelId;
    private CityId cityId;
    private HotelName hotelName;
    private HotelStars hotelStars;
    private HotelAddress hotelAddress;
    private List<HotelPhoto> hotelPhotos;

    private Hotel(HotelId hotelId, CityId cityId, HotelName hotelName, HotelStars hotelStars, HotelAddress hotelAddress, List<HotelPhoto> hotelPhotos) {
        this.hotelId = hotelId;
        this.cityId = cityId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }
    public static Hotel create(HotelId hotelId, CityId cityId, HotelName hotelName, HotelStars hotelStars, HotelAddress hotelAddress, List<HotelPhoto> hotelPhotos){
        Hotel newHotel  = new Hotel(hotelId,cityId,hotelName,hotelStars,hotelAddress,hotelPhotos);
        newHotel.record(new HotelCreatedDomainEvent(cityId.value(),hotelName.value(),
                hotelStars.value(),
                hotelAddress.value(),
                hotelPhotos.stream().map(HotelPhoto::value).findAny().get()));
        return newHotel;
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
            put("id",hotelId.value());
            put("cityId",cityId.value());
            put("hotelName",hotelName.value());
            put("hotelStars",hotelStars.value());
            put("hotelAddress",hotelAddress.value());
            put("photos:", hotelPhotos.stream().map(HotelPhoto::value));

        }};
        return data;
    }

    //TODO: Cuando se haga update crear el record
    public Boolean equalsById(String hotelId){
        return this.hotelId.equals(new HotelId(hotelId));
    }
}
