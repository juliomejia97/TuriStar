package com.webDevelopment.turistar.HotelPlan.Application.All;

import com.webDevelopment.turistar.HotelPlan.Domain.HotelPlan;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HotelPlanAllResponse {

    private List<HotelPlan> hotelPlans;

    public HotelPlanAllResponse(List<HotelPlan> products) {
        this.hotelPlans = products;
    }

    public List<HashMap<String,String> > response()
    {
       return hotelPlans.stream().map(HotelPlan::data).collect(Collectors.toList());
    }
}
