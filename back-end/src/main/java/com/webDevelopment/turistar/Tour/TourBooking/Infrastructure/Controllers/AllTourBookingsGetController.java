package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser.TourBookingsAll;
import com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser.TourBookingsAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AllTourBookingsGetController {


    @Autowired
    private TourBookingsAll tourBookingAllByUser;

    @GetMapping(value="/TourBooking/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        TourBookingsAllResponse response = new TourBookingsAllResponse(tourBookingAllByUser.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> TourException(RuntimeException exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
