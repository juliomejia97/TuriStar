package com.webDevelopment.turistar.Administrator.Hotel.Domain;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelAddress;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelName;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelStars;
import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelCreatedDomainEvent;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelUpdatedDomainEvent;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel extends AggregateRoot {
    private HotelId hotelId;
    private CityId cityId;
    private HotelName hotelName;
    private HotelStars hotelStars;
    private HotelAddress hotelAddress;
    private Optional<List<HotelPhoto>> hotelPhotos;

    private Hotel(HotelId hotelId, CityId cityId, HotelName hotelName, HotelStars hotelStars, HotelAddress hotelAddress, List<HotelPhoto> hotelPhotos) {
        this.hotelId = hotelId;
        this.cityId = cityId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = Optional.of(hotelPhotos);
    }
    public static Hotel create(HotelId hotelId, CityId cityId, HotelName hotelName, HotelStars hotelStars, HotelAddress hotelAddress, List<HotelPhoto> hotelPhotos){
        Hotel newHotel  = new Hotel(hotelId,cityId,hotelName,hotelStars,hotelAddress,hotelPhotos);
        newHotel.record(new HotelCreatedDomainEvent(cityId.value(),hotelId.value(),hotelName.value(),
                hotelStars.value(), hotelAddress.value(),
                newHotel.dataHotelPhotos()));
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
            put("photos:", dataHotelPhotos());

        }};
        return data;
    }
    public ArrayList<String> dataHotelPhotos(){
        ArrayList<String> response = new ArrayList<>();
        if(this.hotelPhotos.isPresent()) {
            List<HotelPhoto> photos  = this.hotelPhotos.get();
            photos.stream().forEach(hotelPhoto -> response.add(hotelPhoto.value()));
        }
        return response;
    }
    public void updateHotel(String hotelName, Double hotelStars, List<HotelPhoto> hotelPhotos, String hotelAddress){
        this.hotelName = new HotelName(hotelName);
        this.hotelStars = new HotelStars(hotelStars);
        this.hotelAddress = !hotelAddress.isEmpty() ?  new HotelAddress(hotelAddress):this.hotelAddress;
        this.hotelPhotos.get().addAll(hotelPhotos);
        this.record(new HotelUpdatedDomainEvent(cityId.value(), hotelId.value(),
                hotelName,hotelStars,hotelAddress,dataHotelPhotos()));
    }

    public Boolean AddressWillChange(String hotelName){
        return !this.hotelName.value().equals(hotelName);
    }
    public Boolean equalsById(String hotelId){
        return this.hotelId.equals(new HotelId(hotelId));
    }

    public void clearPhotos() {
        this.hotelPhotos.get().clear();
    }
}
