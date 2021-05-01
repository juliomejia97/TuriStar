package com.webDevelopment.turistar.Shared.Domain.Tour;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class TourId extends CustomUUID {
    public TourId(String value) {
        super(value);
    }

    private TourId(){
        super("");
    }
}
