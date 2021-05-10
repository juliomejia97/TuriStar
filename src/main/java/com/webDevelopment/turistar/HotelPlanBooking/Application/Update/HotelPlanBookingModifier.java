package com.webDevelopment.turistar.HotelPlanBooking.Application.Update;

import com.webDevelopment.turistar.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingNotExist;
import com.webDevelopment.turistar.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;

import java.time.LocalDate;
import java.util.Optional;

public class HotelPlanBookingModifier {

    private HotelPlanBookingRepository hotelPlanBookingRepository;

    public HotelPlanBookingModifier(HotelPlanBookingRepository hotelPlanBookingRepository) {
        this.hotelPlanBookingRepository = hotelPlanBookingRepository;
    }

    public void execute(String hotelPlanBookingId, LocalDate hotelPlanBookingInitDate, LocalDate hotelPlanBookingEndDate) throws HotelPlanBookingNotExist {
        Optional<HotelPlanBooking> hotelPlanBookingUpdated = hotelPlanBookingRepository.find(hotelPlanBookingId);
        if(hotelPlanBookingUpdated.isEmpty()){
            throw new HotelPlanBookingNotExist("The hotel plan booking not exist");
        }
        HotelPlanBooking hotelPlanBookingToUpdate = hotelPlanBookingUpdated.get();
        hotelPlanBookingToUpdate.updateHotelPlanBooking(hotelPlanBookingInitDate,hotelPlanBookingEndDate);
        this.hotelPlanBookingRepository.update(hotelPlanBookingToUpdate);
    }

}
