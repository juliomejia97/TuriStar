package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.Hotel.Application.Find.HotelFinder;
import com.webDevelopment.turistar.Administrator.Hotel.Application.Find.HotelResponse;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions.HotelNotExists;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/admin")
public class FindHotelGetController {

    @Autowired
    private HotelFinder hotelFinder;

    @GetMapping(value="/Hotel/{idHotel}")
    public ResponseEntity<HashMap> execute(@PathVariable String idHotel){
        HotelResponse response = hotelFinder.execute(idHotel);
        return ResponseEntity.status(HttpStatus.FOUND).body(response.response());
    }

    @ExceptionHandler({HotelNotExists.class, UUIDNotValid.class})
    public ResponseEntity<HashMap> invalidInformation(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
