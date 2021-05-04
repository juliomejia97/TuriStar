package com.webDevelopment.turistar.Hotel.HotelPlan.Application.All;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.HotelPlan;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions.HotelPlanNotExist;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Ports.HotelPlanRepository;

import java.util.List;
import java.util.Optional;

public class HotelPlanAll {

    private HotelPlanRepository hotelPlanRepository;

    public HotelPlanAll(HotelPlanRepository hotelPlanRepository){
        this.hotelPlanRepository = hotelPlanRepository;
    }

    public List<HotelPlan> execute() {
        Optional<List<HotelPlan>> hotelPlans = hotelPlanRepository.all();
        if(hotelPlans.isEmpty()){
            throw new HotelPlanNotExist("There are no hotel plans in the database, contact your admin");
        }
        //TODO: Get only active cities
        return hotelPlans.get();
    }
}
