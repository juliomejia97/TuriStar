package com.webDevelopment.turistar.HotelPlanBooking.Domain.Exceptions;

public class InvalidInitDate extends RuntimeException {
    public InvalidInitDate(String message) {
        super(message);
    }
}
