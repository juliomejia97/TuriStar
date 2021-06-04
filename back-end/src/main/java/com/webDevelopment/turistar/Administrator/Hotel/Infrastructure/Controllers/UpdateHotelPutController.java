package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.Hotel.Application.Update.HotelModifer;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelNotExists;
import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/admin/Hotel")
public class UpdateHotelPutController {

    @Autowired
    private HotelModifer hotelModifer;

    @PutMapping(value = "/{idHotel}")
    public ResponseEntity<String> execute(@PathVariable("idHotel") String idHotel, @RequestBody UpdateHotelPutController.Request request){
        hotelModifer.execute(idHotel, request.getHotelName(), request.getCityName(), request.getHotelStars(), request.getPhotos());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler({UUIDNotValid.class, HotelNotExists.class, BadInfoError.class})
    public ResponseEntity<HashMap> invalidInformation(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private static class Request{
        private Double hotelStars;
        private String hotelName;
        private String cityName;
        private List<String> photos;

        public Double getHotelStars() {
            return hotelStars;
        }

        public void setHotelStars(Double hotelStars) {
            this.hotelStars = hotelStars;
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
    }
}
