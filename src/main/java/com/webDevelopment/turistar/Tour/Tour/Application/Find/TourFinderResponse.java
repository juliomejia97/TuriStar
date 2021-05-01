package com.webDevelopment.turistar.Tour.Tour.Application.Find;

import com.webDevelopment.turistar.Shared.Application.Response;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.HashMap;

public class TourFinderResponse implements Response {

    private final Tour tour;
    private HashMap<String, Object> response;

    public TourFinderResponse(Tour tour) {
        this.tour = tour;
    }

    @Override
    public HashMap response() {
        this.response = tour.data();
        return response;
    }
}
