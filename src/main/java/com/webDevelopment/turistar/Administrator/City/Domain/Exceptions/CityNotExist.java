package com.webDevelopment.turistar.Administrator.City.Domain.Exceptions;

public class CityNotExist extends RuntimeException{
    public CityNotExist(String message) {
        super(message);
    }
}
