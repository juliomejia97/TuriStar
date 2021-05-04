package com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions;

public class InvalidEndDate extends RuntimeException {
    public InvalidEndDate(String message) {
        super(message);
    }
}
