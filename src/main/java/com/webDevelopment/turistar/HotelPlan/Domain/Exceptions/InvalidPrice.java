package com.webDevelopment.turistar.HotelPlan.Domain.Exceptions;

public class InvalidPrice extends RuntimeException {
    public InvalidPrice(String message) {
        super(message);
    }
}
