package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "admin/City")
public class UpdateCityPutController {

    @Autowired
    private CityModifier cityModifier;

    @PutMapping(value="/{idCity}")
    public ResponseEntity<String> execute(@PathVariable int idCity, @RequestBody Request request){
        cityModifier.execute(request.getCityId(), request.getCityName(), request.getCityCountry());
        return ResponseEntity.status(HttpStatus.OK).body("City "+ request.getCityName()+" has been modified");
    }

    private static class Request{
        private String cityId;
        private String cityName;
        private String cityCountry;

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

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
