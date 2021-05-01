package com.webDevelopment.turistar.Tour.Tour.Application.All;

import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ToursAllResponse {
    private List<Tour> tours;

    public ToursAllResponse(List<Tour> tours) {
        this.tours = tours;
    }

    public List<HashMap<String,Object>> response()
    {
        return tours.stream().map(Tour::data).collect(Collectors.toList());
    }
}
