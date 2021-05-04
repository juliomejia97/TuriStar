package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers.UpdateCityPutController;
import com.webDevelopment.turistar.Administrator.TourSpot.Application.Update.TourSpotModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/TourSpot")
public class UpdateTourSpotPutController {
    @Autowired
    private TourSpotModifier spotModifier;

    @PutMapping(value="/{idTourSpot}")
    public ResponseEntity<String> execute(@PathVariable String idTourSpot, @RequestBody UpdateTourSpotPutController.Request request){
        spotModifier.execute(idTourSpot, request.getTourName(), request.getCityName());
        return ResponseEntity.status(HttpStatus.OK).body("Tour "+ request.getTourName()+" has been modified");
    }

    private static class Request{
        private String tourName;
        private String cityName;

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
