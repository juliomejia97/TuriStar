package com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions;

public class HotelPlanBookingAlreadyDeleted extends RuntimeException{
    public HotelPlanBookingAlreadyDeleted(String message) {
        super(message);
    }
}
