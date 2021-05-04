package com.webDevelopment.turistar.HotelPlan.Application.Update;

import com.webDevelopment.turistar.HotelPlan.Domain.HotelPlan;
import com.webDevelopment.turistar.HotelPlan.Domain.Exceptions.HotelPlanNotExist;
import com.webDevelopment.turistar.HotelPlan.Domain.Ports.HotelPlanRepository;

import java.util.Optional;

public class HotelPlanModifier {

    private HotelPlanRepository hotelPlanRepository;

    public HotelPlanModifier(HotelPlanRepository hotelPlanRepository) {
        this.hotelPlanRepository = hotelPlanRepository;
    }

    public void execute(String hotelPlanId, String hotelPlanDescription,double hotelPlanPrice,double hotelPlanPeopleNumber) throws HotelPlanNotExist {
        Optional<HotelPlan> hotelPlanUpdated = hotelPlanRepository.find(hotelPlanId);
        if(hotelPlanUpdated.isEmpty()){
            throw new HotelPlanNotExist("The hotel plan not exist");
        }
        HotelPlan hotelPlanToUpdate = hotelPlanUpdated.get();
        hotelPlanToUpdate.updatehotelPlan(hotelPlanDescription,hotelPlanPrice,hotelPlanPeopleNumber);
        this.hotelPlanRepository.update(hotelPlanId, hotelPlanToUpdate);
    }
}
