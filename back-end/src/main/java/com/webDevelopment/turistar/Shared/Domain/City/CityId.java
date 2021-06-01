package com.webDevelopment.turistar.Shared.Domain.City;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class CityId extends CustomUUID {

    public CityId(String value) {
        super(value);
    }

    private CityId(){
        super();
    }

}
