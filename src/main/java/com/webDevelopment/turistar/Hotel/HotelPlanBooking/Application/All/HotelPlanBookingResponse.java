package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Application.All;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HotelPlanBookingResponse {

    private List<HotelPlanBooking> hotelPlanBooking;

    public HotelPlanBookingResponse(List<HotelPlanBooking> products) {
        this.hotelPlanBooking = products;
    }

    public List<HashMap<String,String> > response()
    {
       return hotelPlanBooking.stream().map(HotelPlanBooking::data).collect(Collectors.toList());
    }
}
