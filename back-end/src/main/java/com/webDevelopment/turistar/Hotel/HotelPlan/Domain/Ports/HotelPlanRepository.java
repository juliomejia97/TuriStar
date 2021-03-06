package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Ports;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.HotelPlan;

import java.util.List;
import java.util.Optional;

public interface HotelPlanRepository {
    void update(HotelPlan hotelPlan);
    Optional<HotelPlan> find(String hotelPlanId);
    void save(HotelPlan hotelPlan);
    Optional<List<HotelPlan>> all();
}
