package com.webDevelopment.turistar.Administrator.Hotel.Application.Create;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelCreator {
    private HotelRepository repository;
    private AddressInfo inforService;
    private GeoCodeInfoService service;
    private EventBus eventBus;
    public HotelCreator(HotelRepository repository, GeoCodeInfoService service, EventBus eventBus) {
        this.repository = repository;
        this.service = service;
        this.inforService = new AddressInfo(service);
        this.eventBus = eventBus;
    }

    public void execute(String hotelId, String cityId, String hotelName, String cityName, Double hotelStars,HashMap<Integer, String> photos) {
        Optional<Hotel> hotelDuplicated = repository.find(hotelId);
        if(hotelDuplicated.isPresent()){
            throw new HotelAlreadyExists("The hotel is duplicated");
        }
        String hotelAddress = inforService.execute(hotelName,cityName);
        List<HotelPhoto> photosAsList = photos.entrySet().stream().map(p -> new HotelPhoto(p.getKey(),p.getValue())).collect(Collectors.toList());
        Hotel hotel = Hotel.create(new HotelId(hotelId), new CityId(cityId), new HotelName(hotelName),
                new HotelStars(hotelStars),new HotelAddress(hotelAddress), photosAsList);
        repository.save(hotel);
        eventBus.publish(hotel.pullDomainEvents());
    }
}
