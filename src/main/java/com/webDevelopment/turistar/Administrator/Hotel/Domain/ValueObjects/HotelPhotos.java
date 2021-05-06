package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.PhotoIsEmpty;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

import java.util.HashMap;
import java.util.Optional;

public class HotelPhotos {
    private HashMap<Integer, String> photos;

    public HotelPhotos(HashMap<Integer, String> photos) {
        this.validate(photos);
        this.photos = photos;
    }
    private HotelPhotos(){}
    private void validate(HashMap<Integer, String> photos) {
        Optional<String> empties = photos.values().stream()
                .filter(String::isEmpty).findAny();
        if(empties.isPresent()){
            throw new PhotoIsEmpty("There is no photo or any photo has no URL");
        }
    }
}
