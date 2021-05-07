package com.webDevelopment.turistar.Administrator.TourSpot.Application.Find;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Shared.Application.Response;

import java.util.HashMap;
import java.util.List;

public class TourSpotResponse implements Response {
    private final TourSpot tourSpot;
    private HashMap<String, Object> response;

    public TourSpotResponse(TourSpot tourSpot) {
        this.tourSpot = tourSpot;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = tourSpot.data();
        return response;
    }
}
