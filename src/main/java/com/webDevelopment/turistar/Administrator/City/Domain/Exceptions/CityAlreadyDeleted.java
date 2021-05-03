package com.webDevelopment.turistar.Administrator.City.Domain.Exceptions;

public class CityAlreadyDeleted extends RuntimeException{
    public CityAlreadyDeleted(String message) {
        super(message);
    }
}
