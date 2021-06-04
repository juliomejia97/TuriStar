package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.TourSpot.Application.All.TourSpotAll;
import com.webDevelopment.turistar.Administrator.TourSpot.Application.All.TourSpotAllResponse;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotsNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AllTourSpotGetController {

    @Autowired
    private TourSpotAll tourSpotAll;

    @GetMapping(value = "/TourSpot/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        TourSpotAllResponse response = new TourSpotAllResponse(tourSpotAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(TourSpotsNotExists.class)
    public ResponseEntity<HashMap> tourSpotsNotExists(TourSpotsNotExists exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
