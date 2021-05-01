package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;


import com.webDevelopment.turistar.Tour.TourBooking.Application.Delete.TourBookingDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RemoveTourBookingDeleteController {

    @Autowired
    private TourBookingDelete tourBookingDeleter;

    @DeleteMapping(value="/{idTourBooking}")
    public ResponseEntity<String> execute(@PathVariable String idTourBooking){
        tourBookingDeleter.execute(idTourBooking);
        return ResponseEntity.status(HttpStatus.OK).body("City "+ idTourBooking +" has been deleted");
    }
}
