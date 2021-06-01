package com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Exceptions;

public class InvalidQuantity extends RuntimeException {
    public InvalidQuantity(String message) {
        super(message);
    }
}
