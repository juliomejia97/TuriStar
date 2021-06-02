package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.Hotel.Application.Create.HotelCreator;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.*;
import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class CreateHotelPostController {

    @Autowired
    private HotelCreator hotelCreator;

    @PostMapping(value="/Hotel/create")
    public ResponseEntity execute(@RequestBody CreateHotelPostController.Request request){
        hotelCreator.execute(request.getHotelId(),request.getCityId(),
                request.getHotelName(),request.getCityName(), request.getHotelStars(),request.getPhotos());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({HotelAlreadyExists.class, BadInfoError.class, UUIDNotValid.class, InvalidHotelName.class
    , InvalidHotelRanking.class, InvalidHotelAddress.class, InvalidPhotoFormat.class})
    public ResponseEntity<HashMap> handleExceptions(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    private static class Request{
        private String hotelId;
        private String cityId;
        private Double hotelStars;
        private String hotelName;
        private String cityName;
        private List<String> photos;

        public String getHotelId() {
            return hotelId;
        }

        public void setHotelId(String hotelId) {
            this.hotelId = hotelId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public List<String> getPhotos() {
            return photos;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }

        public Double getHotelStars() {
            return hotelStars;
        }

        public void setHotelStars(Double hotelStars) {
            this.hotelStars = hotelStars;
        }
    }
}
