package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Controllers;


import com.webDevelopment.turistar.Tour.Tour.Application.Find.TourFinder;
import com.webDevelopment.turistar.Tour.Tour.Application.Find.TourFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class FindTourByIdGetController {

    @Autowired
    private TourFinder tourFinder;

    @GetMapping(value="/Tour/{id}")
    public ResponseEntity<HashMap<String,Object>> execute(@PathVariable String id){
        TourFinderResponse response = tourFinder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
