package com.webDevelopment.turistar.Administrator.City.Domain.Exceptions;

public class CitiesNotExist extends RuntimeException{
    public CitiesNotExist(String message) {
        super(message);
    }
}
