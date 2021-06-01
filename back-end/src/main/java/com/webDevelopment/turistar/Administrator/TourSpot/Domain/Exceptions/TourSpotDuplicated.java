package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Exceptions;

public class TourSpotDuplicated extends RuntimeException {
    public TourSpotDuplicated(String message) {
        super(message);
    }
}
