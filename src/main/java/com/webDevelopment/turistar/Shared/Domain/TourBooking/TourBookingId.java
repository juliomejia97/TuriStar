package com.webDevelopment.turistar.Shared.Domain.TourBooking;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class TourBookingId extends CustomUUID {
    public TourBookingId(String value) {
        super(value);
    }

    private TourBookingId(){
        super();
    }
}
