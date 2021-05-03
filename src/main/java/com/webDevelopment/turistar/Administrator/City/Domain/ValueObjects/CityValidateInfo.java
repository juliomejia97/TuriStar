package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import com.webDevelopment.turistar.Administrator.City.Domain.Exceptions.BadInfoError;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.InformationService;

public class CityValidateInfo {
    private InformationService service;

    public CityValidateInfo(InformationService service) {
        this.service = service;
    }

    public void execute(String cityName, String cityCountry){
        if(!service.validate(cityName,cityCountry)){
            throw new BadInfoError("The city that you are trying to update does not exists review the name and the country relationship");
        }
    }
}
