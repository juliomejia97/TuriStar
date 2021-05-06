package com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import com.webDevelopment.turistar.Shared.Domain.Ports.InformationDetailService;

import java.util.Optional;

public class AddressInfo {
    private InformationDetailService detailService;

    public AddressInfo(InformationDetailService informationDetailService) {
        this.detailService = informationDetailService;
    }

    public String execute(String hotelName, String cityName){
        Optional<String> possibleAddress = detailService.addressInfo(hotelName,cityName);
        if(possibleAddress.isEmpty()){
            throw new BadInfoError("The Hotel that you are trying to search does not exists review the name and the city relationship");
        }
        return possibleAddress.get();
    }

}
