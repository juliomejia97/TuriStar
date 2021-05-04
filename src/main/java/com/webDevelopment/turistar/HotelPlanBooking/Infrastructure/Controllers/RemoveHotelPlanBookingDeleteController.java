package com.webDevelopment.turistar.HotelPlanBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.HotelPlanBooking.Application.Delete.HotelPlanBookingDelete;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingNotExist;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingAlreadyDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/hotel/HotelPlanBooking")
public class RemoveHotelPlanBookingDeleteController {

    @Autowired
    private HotelPlanBookingDelete hotelPlanBookingDeleter;

    @DeleteMapping(value="/{idHotelPlanBooking}")
    public ResponseEntity<String> execute(@PathVariable String idHotelPlanBooking){
        hotelPlanBookingDeleter.execute(idHotelPlanBooking);
        return ResponseEntity.status(HttpStatus.OK).body("HotelPlanBooking "+ idHotelPlanBooking +" has been deleted");
    }

    @ExceptionHandler(HotelPlanBookingNotExist.class)
    public ResponseEntity<HashMap> handleDataError(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(HotelPlanBookingAlreadyDeleted.class)
    public ResponseEntity<HashMap> handleHotelPlanBookingDeleted(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
