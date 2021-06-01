package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions;

public class InvalidPrice extends RuntimeException {
    public InvalidPrice(String message) {
        super(message);
    }
}
