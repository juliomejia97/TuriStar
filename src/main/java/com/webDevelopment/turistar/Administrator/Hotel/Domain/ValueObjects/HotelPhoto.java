package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.InvalidPhotoFormat;

import java.util.HashMap;

public class HotelPhoto {
    private Integer idPhoto;
    private String urlPhoto;

    public HotelPhoto(Integer idPhoto, String urlPhoto) {
        this.validate(idPhoto,urlPhoto);
        this.idPhoto = idPhoto;
        this.urlPhoto = urlPhoto;
    }

    private void validate(Integer idPhoto, String urlPhoto) {
        if(idPhoto < 0 || urlPhoto.length()  < 0) {
            throw new InvalidPhotoFormat("The photo is invalid, the id has to be an integer and the url must be not null");
        }
    }

    private HotelPhoto(){}
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("idPhoto", idPhoto);
            put("urlPhoto", urlPhoto);
        }};
        return data;
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
}
