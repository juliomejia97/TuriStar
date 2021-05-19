package com.webDevelopment.turistar.Administrator.City.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;

import java.util.*;
import java.util.stream.Collectors;

public class City extends AggregateRoot {

    private CityId cityId;
    private CityName cityName;
    private CityCountry cityCountry;
    private CityActive cityActive;
    private Optional<List<TourSpotDetail>> tourSpots;
    private Optional<List<HotelDetail>> hotels;
    private City(){}

    private City(CityId cityId, CityName cityName, CityCountry cityCountry, List<TourSpotDetail> tourSpots, List<HotelDetail> hotelDetails) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.cityActive= new CityActive(true);
        this.tourSpots = Optional.ofNullable(tourSpots);
        this.hotels = Optional.ofNullable(hotelDetails);
    }

    public static City create(CityId cityId, CityName cityName, CityCountry cityCountry){
        City newCity = new City(cityId,cityName,cityCountry,null,null);
        return newCity;
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

    public HashMap<String, Object> data()
    {
        return new HashMap<>() {{
            put("id", cityId.value());
            put("name", cityName.value());
            put("country", cityCountry.value());
            put("cityActive", cityActive.value().toString());
            put("tourSpots",dataTourSpots());
            put("hotels",dataHotels());
        }};
    }

    public Optional<List<HashMap<String, Object>>> dataTourSpots(){
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.tourSpots.isPresent()) {
            response = Optional.of(this.tourSpots.get().stream().map(TourSpotDetail::data).collect(Collectors.toList()));
        }
        return response;
    }
    public Optional<List<HashMap<String, Object>>> dataHotels(){
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.hotels.isPresent()){
            response = Optional.of(this.hotels.get().stream().map(HotelDetail::data).collect(Collectors.toList()));
        }
        return response;
    }
    public boolean equalsById(String cityId) {
        return this.cityId.equals(new CityId(cityId));
    }

    public void addTourSpots(String tourSpotName, String idTourSpot, String description, Double latitude, Double longitude) {
        List<TourSpotDetail> tourSpotDetails = this.tourSpots.isEmpty() ?
                new ArrayList<>():this.tourSpots.get();
        tourSpotDetails.add(new TourSpotDetail(idTourSpot,tourSpotName,latitude,longitude,description));
        this.tourSpots = Optional.of(tourSpotDetails);
    }

    public void updateTourSpotsDetail(String tourSpotId, String tourSpotName, Double latitude, Double longitude, String description) {
        TourSpotDetail newTourSpotDetail = new TourSpotDetail(tourSpotId,tourSpotName,latitude,longitude,description);
        List<TourSpotDetail> tourSpotDetails = this.tourSpots.get();
        TourSpotDetail tourSpotDetailActual = tourSpotDetails.stream()
                .filter(tourSpot -> tourSpot.tourSpotDetailEqualsById(tourSpotId)).findFirst().get();
        tourSpotDetails.remove(tourSpotDetailActual);
        tourSpotDetails.add(newTourSpotDetail);
        this.tourSpots = Optional.of(tourSpotDetails);
    }

    public void addHotel(String hotelId, String hotelName, String hotelAddress, Double hotelStars, HashMap<String, Object> hotelPhotos) {
        List<HotelDetail> hotelDetails = this.hotels.isEmpty() ?
                new ArrayList<>():this.hotels.get();
        hotelDetails.add(new HotelDetail(hotelId,hotelName,hotelStars,hotelAddress,hotelPhotos));
        this.hotels = Optional.of(hotelDetails);
    }
}
