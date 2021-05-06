package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class HotelAlreadyExists extends RuntimeException {
    public HotelAlreadyExists(String message) {
        super(message);
    }
}
