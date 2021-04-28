package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Delete.CityDelete;
import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/City")
public class RemoveCityDeleteController {

    @Autowired
    private CityDelete cityDeleter;

    @DeleteMapping(value="/{idCity}")
    public ResponseEntity<String> execute(@PathVariable String idCity){
        cityDeleter.execute(idCity);
        return ResponseEntity.status(HttpStatus.OK).body("City "+ idCity +" has been deleted");
    }
}
