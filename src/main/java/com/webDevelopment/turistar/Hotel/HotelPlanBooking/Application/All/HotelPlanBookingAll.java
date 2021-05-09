package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Application.All;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.HotelPlanBookingNotExist;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;

import java.util.List;
import java.util.Optional;

public class HotelPlanBookingAll {

    private HotelPlanBookingRepository hotelPlanBookingRepository;

    public HotelPlanBookingAll(HotelPlanBookingRepository hotelPlanBookingRepository){
        this.hotelPlanBookingRepository = hotelPlanBookingRepository;
    }

    public List<HotelPlanBooking> execute() {
        Optional<List<HotelPlanBooking>> hotelPlanBookings = hotelPlanBookingRepository.all();
        if(hotelPlanBookings.isEmpty()){
            throw new HotelPlanBookingNotExist("There are no hotel plan bookings in the database, contact your admin");
        }
        return hotelPlanBookings.get();
    }
}
