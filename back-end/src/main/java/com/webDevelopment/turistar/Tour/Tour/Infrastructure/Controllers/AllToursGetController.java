package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.Tour.Application.All.ToursAll;
import com.webDevelopment.turistar.Tour.Tour.Application.All.ToursAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/Tour")
public class AllToursGetController {

    @Autowired
    private ToursAll toursAll;

    @GetMapping(value="/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        ToursAllResponse response = new ToursAllResponse(toursAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
