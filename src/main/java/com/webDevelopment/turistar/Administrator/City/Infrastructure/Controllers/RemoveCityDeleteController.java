package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Delete.CityDelete;
import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CitiesNotExist;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityAlreadyDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/hotel/City")
public class RemoveCityDeleteController {

    @Autowired
    private CityDelete cityDeleter;

    @DeleteMapping(value="/{idCity}")
    public ResponseEntity<String> execute(@PathVariable String idCity){
        cityDeleter.execute(idCity);
        return ResponseEntity.status(HttpStatus.OK).body("City "+ idCity +" has been deleted");
    }

    @ExceptionHandler(CitiesNotExist.class)
    public ResponseEntity<HashMap> handleDataError(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(CityAlreadyDeleted.class)
    public ResponseEntity<HashMap> handleCityDeleted(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
