package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions;

public class HotelPlanBookingAlreadyDeleted extends RuntimeException{
    public HotelPlanBookingAlreadyDeleted(String message) {
        super(message);
    }
}
