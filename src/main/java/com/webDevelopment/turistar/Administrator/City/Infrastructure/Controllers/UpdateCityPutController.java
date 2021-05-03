package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.BadInfoError;
import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.LengthNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/admin/City")
public class UpdateCityPutController {

    @Autowired
    private CityModifier cityModifier;

    @PutMapping(value="/{idCity}")
    public ResponseEntity<String> execute(@PathVariable String idCity, @RequestBody Request request){
        cityModifier.execute(idCity, request.getCityName(), request.getCityCountry());
        return ResponseEntity.status(HttpStatus.OK).body("City "+ request.getCityName()+" has been modified");
    }

    //TODO: Captura de Excepciones
    @ExceptionHandler(LengthNotValid.class)
    public ResponseEntity<HashMap> handleDataErrors(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(BadInfoError.class)
    public ResponseEntity<HashMap> handleBadInfoCity(BadInfoError exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    private static class Request{
        private String cityName;
        private String cityCountry;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityCountry() {
            return cityCountry;
        }

        public void setCityCountry(String cityCountry) {
            this.cityCountry = cityCountry;
        }
    }

}
