package com.webDevelopment.turistar.HotelPlanBooking.Application.Delete;

import com.webDevelopment.turistar.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingNotExist;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;

import java.util.Optional;

public class HotelPlanBookingDelete {
    private HotelPlanBookingRepository hotelPlanBookingRepository;

    public HotelPlanBookingDelete(HotelPlanBookingRepository hotelPlanBookingRepository){
        this.hotelPlanBookingRepository = hotelPlanBookingRepository;
    }

    public void execute(String hotelPlanBookingId) throws HotelPlanBookingNotExist {
        Optional<HotelPlanBooking> hotelPlanBookingUpdated = hotelPlanBookingRepository.find(hotelPlanBookingId);
        if(hotelPlanBookingUpdated.isEmpty()){
            throw new HotelPlanBookingNotExist("The hotelPlanBooking not exist");
        }
        HotelPlanBooking hotelPlanBookingToUpdate = hotelPlanBookingUpdated.get();
        hotelPlanBookingToUpdate.deleteHotelPlanBooking();
        this.hotelPlanBookingRepository.update(hotelPlanBookingToUpdate);
    }

}
