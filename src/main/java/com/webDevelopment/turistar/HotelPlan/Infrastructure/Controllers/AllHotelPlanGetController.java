package com.webDevelopment.turistar.HotelPlan.Infrastructure.Controllers;

import com.webDevelopment.turistar.HotelPlan.Application.All.HotelPlanAll;
import com.webDevelopment.turistar.HotelPlan.Application.All.HotelPlanAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class AllHotelPlanGetController {

    @Autowired
    private HotelPlanAll hotelPlanAll;

    @GetMapping(value="/HotelPlan/")
    public ResponseEntity<List<HashMap<String,String>>> execute(){
        HotelPlanAllResponse response = new HotelPlanAllResponse(hotelPlanAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
