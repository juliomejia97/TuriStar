package com.webDevelopment.turistar.HotelPlan.Domain.Ports;

import com.webDevelopment.turistar.HotelPlan.Domain.HotelPlan;

import java.util.List;
import java.util.Optional;

public interface HotelPlanRepository {
    void update(String hotelPlanId, HotelPlan hotelPlan);
    Optional<HotelPlan> find(String hotelPlanId);
    void save(HotelPlan hotelPlan);
    Optional<List<HotelPlan>> all();
}
