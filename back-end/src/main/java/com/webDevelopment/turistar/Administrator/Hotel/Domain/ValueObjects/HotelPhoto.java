package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.InvalidPhotoFormat;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class HotelPhoto extends StringValueObject {

    public HotelPhoto(String urlPhoto) {
        this.validate(urlPhoto);
        this.value = urlPhoto;
    }

    private void validate(String urlPhoto) {
        if(urlPhoto.length()  < 0) {
            throw new InvalidPhotoFormat("The photo is invalid, the id has to be an integer and the url must be not null");
        }
    }

    private HotelPhoto(){}

}
