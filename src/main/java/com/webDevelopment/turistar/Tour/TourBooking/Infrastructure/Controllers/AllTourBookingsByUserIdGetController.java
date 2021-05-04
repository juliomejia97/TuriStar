package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.Tour.Application.All.ToursAllResponse;
import com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser.TourBookingsAllByUser;
import com.webDevelopment.turistar.Tour.TourBooking.Application.AllByUser.TourBookingsAllByUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

//@RestController
public class AllTourBookingsByUserIdGetController {


    @Autowired
    private TourBookingsAllByUser tourBookingAllByUser;

    @GetMapping(value="/Tour/user/{id}")
    public ResponseEntity<List<HashMap<String,Object>>> execute(@PathVariable  String userId){
        TourBookingsAllByUserResponse response = new TourBookingsAllByUserResponse(tourBookingAllByUser.execute(userId));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
