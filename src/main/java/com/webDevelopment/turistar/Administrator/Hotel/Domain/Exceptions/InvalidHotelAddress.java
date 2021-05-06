package com.webDevelopment.turistar.Administrator.Hotel.Domain.Exceptions;

public class InvalidHotelAddress extends RuntimeException{
    public InvalidHotelAddress(String message) {
        super(message);
    }
}
