package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.InvalidPhotoFormat;
import com.webDevelopment.turistar.Shared.Domain.StringValueObject;

public class TourSpotPhoto extends StringValueObject {
    public TourSpotPhoto(String urlPhoto) {
        this.validate(urlPhoto);
        this.value = urlPhoto;
    }
    private void validate(String urlPhoto) {
        if(urlPhoto.length()  < 0) {
            throw new InvalidPhotoFormat("The photo is invalid, the id has to be an integer and the url must be not null");
        }
    }
}
