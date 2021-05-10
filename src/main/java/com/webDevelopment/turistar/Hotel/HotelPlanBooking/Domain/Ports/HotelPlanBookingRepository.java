package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;

import java.util.List;
import java.util.Optional;

public interface HotelPlanBookingRepository {
    void update(HotelPlanBooking hotelPlanBooking);
    Optional<HotelPlanBooking> find(String cityId);
    void save(HotelPlanBooking hotelPlanBooking);
    Optional<List<HotelPlanBooking>> all();
}
