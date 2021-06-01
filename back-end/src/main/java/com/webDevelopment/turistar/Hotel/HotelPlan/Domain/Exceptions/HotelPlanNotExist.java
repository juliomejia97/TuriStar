package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions;

public class HotelPlanNotExist extends RuntimeException {
    public HotelPlanNotExist(String message) {
        super(message);
    }
}
