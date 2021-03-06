package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAll;
import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAllResponse;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/admin")
public class AllCitiesGetController {

    @Autowired
    private CitiesAll citiesAll;

    @GetMapping(value="/City/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        CitiesAllResponse response = new CitiesAllResponse(citiesAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(CitiesNotExist.class)
    public ResponseEntity<HashMap> citiesEmpty(CitiesNotExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

