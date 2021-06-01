package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;


import com.webDevelopment.turistar.Tour.TourBooking.Application.Delete.TourBookingDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RemoveTourBookingDeleteController {

    @Autowired
    private TourBookingDelete tourBookingDeleter;

    @DeleteMapping(value="/TourBooking/{idTourBooking}")
    public ResponseEntity<String> execute(@PathVariable String idTourBooking){
        tourBookingDeleter.execute(idTourBooking);
        return ResponseEntity.status(HttpStatus.OK).body("City "+ idTourBooking +" has been deleted");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> TourException(RuntimeException exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
