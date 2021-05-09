package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions;

public class InvalidInitDate extends RuntimeException {
    public InvalidInitDate(String message) {
        super(message);
    }
}
