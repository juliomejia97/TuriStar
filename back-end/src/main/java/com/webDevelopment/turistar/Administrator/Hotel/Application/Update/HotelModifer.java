package com.webDevelopment.turistar.Administrator.Hotel.Application.Update;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelNotExists;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.AddressInfo;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.turistar.Shared.Intrastructure.Services.GeoCodeInfoService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelModifer {

    private HotelRepository repository;
    private AddressInfo inforService;
    private GeoCodeInfoService service;
    private EventBus eventBus;
    public HotelModifer(HotelRepository repository, GeoCodeInfoService service, EventBus eventBus) {
        this.repository = repository;
        this.service = service;
        this.inforService = new AddressInfo(service);
        this.eventBus = eventBus;
    }

    public void execute(String idHotel, String hotelName, String cityName, Double hotelStars, List<String> photos) {
        Optional<Hotel> hotelOptional = repository.find(idHotel);
        if(hotelOptional.isEmpty()){
            throw new HotelNotExists("The hotel that you are trying to update does not exists");
        }
        Hotel hotelUpdate = hotelOptional.get();
        String hotelAddress = "";
        if(hotelUpdate.AddressWillChange(hotelName)){
            hotelAddress = inforService.execute(hotelName,cityName);
            hotelUpdate.clearPhotos();
        }
        List<HotelPhoto> photosAsList = photos.stream().map(photo -> new HotelPhoto(photo)).collect(Collectors.toList());
        hotelUpdate.updateHotel(hotelName,hotelStars,photosAsList,hotelAddress);
        repository.update(hotelUpdate);
        eventBus.publish(hotelUpdate.pullDomainEvents());
    }
}
