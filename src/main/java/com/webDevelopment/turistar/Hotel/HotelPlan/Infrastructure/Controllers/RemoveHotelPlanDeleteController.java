package com.webDevelopment.turistar.Hotel.HotelPlan.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.HotelPlan.Application.Delete.HotelPlanDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel/HotelPlan")
public class RemoveHotelPlanDeleteController {

    @Autowired
    private HotelPlanDelete hotelPlanDeleter;

    @DeleteMapping(value="/{idHotelPlan}")
    public ResponseEntity<String> execute(@PathVariable String idHotelPlan){
        hotelPlanDeleter.execute(idHotelPlan);
        return ResponseEntity.status(HttpStatus.OK).body("City "+ idHotelPlan +" has been deleted");
    }
}
