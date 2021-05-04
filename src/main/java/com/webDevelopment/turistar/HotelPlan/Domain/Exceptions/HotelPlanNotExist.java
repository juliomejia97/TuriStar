package com.webDevelopment.turistar.HotelPlan.Domain.Exceptions;

public class HotelPlanNotExist extends RuntimeException {
    public HotelPlanNotExist(String message) {
        super(message);
    }
}
