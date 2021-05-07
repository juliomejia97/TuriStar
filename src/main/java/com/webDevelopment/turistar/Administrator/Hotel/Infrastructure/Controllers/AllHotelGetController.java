package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.Hotel.Application.All.HotelAll;
import com.webDevelopment.turistar.Administrator.Hotel.Application.All.HotelAllResponse;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/admin")
public class AllHotelGetController {

    @Autowired
    private HotelAll hotelAll;

    @RequestMapping(value="/Hotel/")
    public ResponseEntity execute(){
        HotelAllResponse response = new HotelAllResponse(hotelAll.execute());
        return ResponseEntity.status(HttpStatus.FOUND).body(response.response());
    }

    @ExceptionHandler(HotelsEmpty.class)
    public ResponseEntity manageExceptions(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
