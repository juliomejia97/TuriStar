package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAll;
import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAllResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("admin/City")
public class AllCitiesGetController {

    //TODO: realizar inyección
    private CitiesAll citiesAll;

    @GetMapping("/")
    public ResponseEntity<List<HashMap<String,String>>> execute(){
        CitiesAllResponse response = new CitiesAllResponse(citiesAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
