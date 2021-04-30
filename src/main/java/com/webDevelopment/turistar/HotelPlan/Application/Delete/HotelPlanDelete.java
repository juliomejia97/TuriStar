package com.webDevelopment.turistar.HotelPlan.Application.Delete;

import com.webDevelopment.turistar.HotelPlan.Domain.HotelPlan;
import com.webDevelopment.turistar.HotelPlan.Domain.Exceptions.HotelPlanNotExist;
import com.webDevelopment.turistar.HotelPlan.Domain.Ports.HotelPlanRepository;

import java.util.Optional;

public class HotelPlanDelete {
    private HotelPlanRepository hotelPlanRepository;

    public HotelPlanDelete(HotelPlanRepository hotelPlanRepository){
        this.hotelPlanRepository = hotelPlanRepository;
    }

    public void execute(String hotelPlanId) throws HotelPlanNotExist {
        Optional<HotelPlan> hotelPlanUpdated = hotelPlanRepository.find(hotelPlanId);
        if(hotelPlanUpdated.isEmpty()){
            throw new HotelPlanNotExist("The hotel plan not exist");
        }
        HotelPlan hotelPlanToUpdate = hotelPlanUpdated.get();
        hotelPlanToUpdate.deleteHotelPlan();
        this.hotelPlanRepository.update(hotelPlanId, hotelPlanToUpdate);
    }
}
