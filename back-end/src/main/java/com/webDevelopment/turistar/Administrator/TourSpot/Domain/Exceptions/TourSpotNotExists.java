package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions;

public class TourSpotNotExists extends RuntimeException{
    public TourSpotNotExists(String message) {
        super(message);
    }
}
