package com.webDevelopment.turistar.Administrator.TourSpot.Application.All;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourSpotAllResponse {
    private List<TourSpot> tourSpots;

    public TourSpotAllResponse(List<TourSpot> pTourSpots) {
        this.tourSpots = pTourSpots;
    }

    public List<HashMap<String,Object>> response()
    {
        return tourSpots.stream().map(TourSpot::data).collect(Collectors.toList());
    }
}
