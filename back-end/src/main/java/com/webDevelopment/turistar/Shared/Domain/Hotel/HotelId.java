package com.webDevelopment.turistar.Shared.Domain.Hotel;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class HotelId extends CustomUUID {
    public HotelId(String value) {
        super(value);
    }

    private HotelId() {
        super();
    }
}
