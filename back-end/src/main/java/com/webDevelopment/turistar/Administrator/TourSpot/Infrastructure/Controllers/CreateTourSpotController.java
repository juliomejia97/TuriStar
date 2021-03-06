package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.TourSpot.Application.Create.TourSpotCreator;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourDescriptionNotValid;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotDuplicated;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNameNotValid;
import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class CreateTourSpotController {

    @Autowired
    private TourSpotCreator spotCreator;

    @PostMapping(value = "/TourSpot/create")
    public ResponseEntity<HashMap> execute(@RequestBody CreateTourSpotController.Request request){
        spotCreator.execute(request.getTourSpotId(),request.getCityId(),request.getTourName(),
                request.getCityName(),request.getDescription(), request.getPhotos());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({TourSpotDuplicated.class, UUIDNotValid.class, TourSpotNameNotValid.class,
            BadInfoError.class, TourDescriptionNotValid.class})
    public  ResponseEntity<HashMap> informationNotvalid(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    private static class Request{
        private String tourSpotId;
        private String cityId;
        private String tourName;
        private String cityName;
        private String description;
        private List<String> photos;

        public String getTourSpotId() {
            return tourSpotId;
        }

        public void setTourSpotId(String tourSpotId) {
            this.tourSpotId = tourSpotId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getTourName() {
            return tourName;
        }

        public void setTourName(String tourName) {
            this.tourName = tourName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getPhotos() {
            return photos;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }
    }
}
