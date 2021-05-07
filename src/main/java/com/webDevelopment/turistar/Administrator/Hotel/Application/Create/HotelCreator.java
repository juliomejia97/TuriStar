package com.webDevelopment.turistar.Administrator.Hotel.Application.Create;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelAddress;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.AddressInfo;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelName;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelStars;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.*;
import java.util.stream.Collectors;

public class HotelCreator {
    private HotelRepository repository;
    private AddressInfo inforService;
    private GeoCodeInfoService service;
    public HotelCreator(HotelRepository repository, GeoCodeInfoService service) {
        this.repository = repository;
        this.service = service;
        this.inforService = new AddressInfo(service);
    }

    public void execute(String hotelId, String cityId, String hotelName, String cityName, Double hotelStars,HashMap<Integer, String> photos) {
        Optional<Hotel> hotelDuplicated = repository.find(hotelId);
        if(hotelDuplicated.isPresent()){
            throw new HotelAlreadyExists("The hotel is duplicated");
        }
        String hotelAddress = inforService.execute(hotelName,cityName);
        List<HotelPhoto> photosAsList = photos.entrySet().stream().map(p -> new HotelPhoto(p.getKey(),p.getValue())).collect(Collectors.toList());
        Hotel hotel = new Hotel(new HotelId(hotelId), new CityId(cityId), new HotelName(hotelName),
                new HotelStars(hotelStars),new HotelAddress(hotelAddress), photosAsList);
        repository.save(hotel);
    }
}
