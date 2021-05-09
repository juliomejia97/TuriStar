package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions;

public class InvalidEndDate extends RuntimeException {
    public InvalidEndDate(String message) {
        super(message);
    }
}
