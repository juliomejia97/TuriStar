package com.webDevelopment.turistar.Hotel.HotelPlan.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.HotelPlan.Application.Update.HotelPlanModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hotel/hotelPlan")
public class UpdateHotelPlanPutController {

    @Autowired
    private HotelPlanModifier hotelPlanModifier;

    @PutMapping(value="/{idHotelPlan}")
    public ResponseEntity<String> execute(@PathVariable String idHotelPlan, @RequestBody Request request){
        hotelPlanModifier.execute(idHotelPlan, request.getHotelPlanDescription(), request.getHotelPlanPrice(),request.hotelPlanPeopleNumber());
        return ResponseEntity.status(HttpStatus.OK).body("Hotel plan "+ request.getHotelPlanDescription()+" has been modified");
    }

    private static class Request{
        private String hotelPlanDescription;
        private double hotelPlanPeopleNumber;
        private double hotelPlanPrice;

        public void setHotelPlanDescription(String hotelPlanDescription) {
            this.hotelPlanDescription = hotelPlanDescription;
        }

        public void setHotelPlanPeopleNumber(double hotelPlanPeopleNumber) {
            this.hotelPlanPeopleNumber = hotelPlanPeopleNumber;
        }

        public void setHotelPlanPrice(double hotelPlanPrice) {
            this.hotelPlanPrice = hotelPlanPrice;
        }

        public String getHotelPlanDescription() {
            return hotelPlanDescription;
        }

        public double getHotelPlanPrice() {
            return hotelPlanPrice;
        }

        public double hotelPlanPeopleNumber() { return  hotelPlanPeopleNumber;}
    }

}
