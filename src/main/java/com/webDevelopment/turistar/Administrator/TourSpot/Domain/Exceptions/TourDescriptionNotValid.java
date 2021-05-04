package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions;

public class TourDescriptionNotValid extends RuntimeException{
    public TourDescriptionNotValid(String message) {
        super(message);
    }
}
