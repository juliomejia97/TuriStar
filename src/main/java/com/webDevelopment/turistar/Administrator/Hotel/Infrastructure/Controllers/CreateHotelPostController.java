package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.Hotel.Application.Create.HotelCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    //TODO: Manage Exceptions

    private static class Request{
        private String hotelId;
        private String cityId;
        private Double hotelStars;
        private String hotelName;
        private String cityName;
        private HashMap<Integer,String> photos;

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

        public HashMap<Integer, String> getPhotos() {
            return photos;
        }

        public void setPhotos(HashMap<Integer, String> photos) {
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
