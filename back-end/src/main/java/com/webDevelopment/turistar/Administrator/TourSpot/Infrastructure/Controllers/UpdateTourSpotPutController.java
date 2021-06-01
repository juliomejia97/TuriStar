package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.TourSpot.Application.Update.TourSpotModifier;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourDescriptionNotValid;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNameNotValid;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/admin/TourSpot")
public class UpdateTourSpotPutController {
    @Autowired
    private TourSpotModifier spotModifier;

    @PutMapping(value="/{idTourSpot}")
    public ResponseEntity<String> execute(@PathVariable String idTourSpot, @RequestBody UpdateTourSpotPutController.Request request){
        spotModifier.execute(idTourSpot, request.getTourName(), request.getCityName(), request.getDescription());
        return ResponseEntity.status(HttpStatus.OK).body("Tour "+ request.getTourName()+" has been modified");
    }

    @ExceptionHandler({TourDescriptionNotValid.class, TourSpotNameNotValid.class, TourSpotNotExists.class, BadInfoError.class})
    public ResponseEntity<HashMap> invalidInformation(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private static class Request{
        private String tourName;
        private String cityName;
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
    }
}
