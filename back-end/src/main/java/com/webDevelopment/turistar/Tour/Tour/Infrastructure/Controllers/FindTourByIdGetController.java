package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Controllers;


import com.webDevelopment.turistar.Tour.Tour.Application.Find.TourFinder;
import com.webDevelopment.turistar.Tour.Tour.Application.Find.TourFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FindTourByIdGetController {

    @Autowired
    private TourFinder tourFinder;

    @GetMapping(value="/Tour/{id}")
    public ResponseEntity<HashMap<String,Object>> execute(@PathVariable String id){
        TourFinderResponse response = tourFinder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
