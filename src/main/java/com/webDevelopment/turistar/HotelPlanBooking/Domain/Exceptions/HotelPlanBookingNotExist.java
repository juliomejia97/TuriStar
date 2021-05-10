package com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions;

public class HotelPlanBookingNotExist extends RuntimeException {
    public HotelPlanBookingNotExist(String message) {
        super(message);
    }
}
