package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Controllers;


import com.webDevelopment.turistar.Administrator.TourSpot.Application.All.TourSpotAll;
import com.webDevelopment.turistar.Administrator.TourSpot.Application.All.TourSpotAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AllTourSpotGetController {

    @Autowired
    private TourSpotAll tourSpotAll;

    @GetMapping(value = "/TourSpot/")
    public ResponseEntity<List<HashMap<String,String>>> execute(){
        TourSpotAllResponse response = new TourSpotAllResponse(tourSpotAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
