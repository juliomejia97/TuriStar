package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Find.CityFinder;
import com.webDevelopment.turistar.Administrator.City.Application.Find.CityFinderResponse;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.CityNotExist;
import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/admin")
public class FindCityByIdController {
    @Autowired
    private CityFinder cityFinder;

    @GetMapping(value = "/City/find/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id){
        CityFinderResponse response = cityFinder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler({CityNotExist.class})
    public ResponseEntity<HashMap> CityNotExists(CityNotExist exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(UUIDNotValid.class)
    public ResponseEntity<HashMap> UUIDNotValid(UUIDNotValid exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    
}
