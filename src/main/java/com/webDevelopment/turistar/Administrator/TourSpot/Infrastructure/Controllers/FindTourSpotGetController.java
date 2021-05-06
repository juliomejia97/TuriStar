package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.TourSpot.Application.Find.TourSpotFinder;
import com.webDevelopment.turistar.Administrator.TourSpot.Application.Find.TourSpotResponse;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions.TourSpotNotExists;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/admin")
public class FindTourSpotGetController {

    @Autowired
    private TourSpotFinder tourSpotFinder;

    @RequestMapping("/TourSpot/{idTourSpot}")
    public ResponseEntity<HashMap> execute(@PathVariable("idTourSpot") String id){
        TourSpotResponse response = tourSpotFinder.execute(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response.response());
    }

    @ExceptionHandler({TourSpotNotExists.class, UUIDNotValid.class})
    public ResponseEntity<HashMap> invalidInformation(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
