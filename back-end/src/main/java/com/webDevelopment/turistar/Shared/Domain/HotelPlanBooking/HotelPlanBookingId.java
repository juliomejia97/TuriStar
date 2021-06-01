package com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class HotelPlanBookingId extends CustomUUID {

    public HotelPlanBookingId(String value) {
        super(value);
    }

    private HotelPlanBookingId(){
        super();
    }

}
