package com.webDevelopment.turistar.Shared.Domain.HotelPlan;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class HotelPlanId extends CustomUUID {

    public HotelPlanId(String value) {
        super(value);
    }

    private HotelPlanId(){
        super("");
    }
}
