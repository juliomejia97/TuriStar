package com.webDevelopment.turistar.Administrator.City.Infrastructure.Controllers;

import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cities")
public class UpdateCityPutController {

    CityModifier cityModifier;


}
