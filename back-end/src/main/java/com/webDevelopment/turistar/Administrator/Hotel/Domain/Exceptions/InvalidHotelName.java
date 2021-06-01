package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class InvalidHotelName extends RuntimeException {
    public InvalidHotelName(String message) {
        super(message);
    }
}
