package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions;

public class TourSpotsNotExists extends RuntimeException {
    public TourSpotsNotExists(String message) {
        super(message);
    }
}
