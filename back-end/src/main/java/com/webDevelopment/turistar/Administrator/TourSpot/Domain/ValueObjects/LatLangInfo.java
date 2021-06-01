package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.BadInfoError;
import com.webDevelopment.turistar.Shared.Domain.Ports.InformationDetailService;

import java.util.List;
import java.util.Optional;

public class LatLangInfo {
    private InformationDetailService detailService;

    public LatLangInfo(InformationDetailService informationDetailService) {
        this.detailService = informationDetailService;
    }
    public List<Double> execute(String tourName, String cityName){
        Optional<List<Double>> data = detailService.latitudeLongitudeInfo(tourName,cityName);
        if(data.isEmpty()){
            throw new BadInfoError("The Tour Spot that you are trying to search does not exists review the name and the city relationship");
        }
        return data.get();
    }
}
