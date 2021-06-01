package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class HotelNotExists extends RuntimeException {
    public HotelNotExists(String message) {
        super(message);
    }
}
