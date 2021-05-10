package com.webDevelopment.turistar.HotelPlanBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.HotelPlanBooking.Application.All.HotelPlanBookingAll;
import com.webDevelopment.turistar.HotelPlanBooking.Application.All.HotelPlanBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class AllHotelPlanBookingsGetController {

    @Autowired
    private HotelPlanBookingAll hotelPlanBookingAll;

    @GetMapping(value="/HotelPlanBooking/")
    public ResponseEntity<List<HashMap<String,String>>> execute(){
        HotelPlanBookingResponse response = new HotelPlanBookingResponse(hotelPlanBookingAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
