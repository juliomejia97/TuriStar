package com.webDevelopment.turistar.Shared.Domain.Ports;

import java.util.List;
import java.util.Optional;

public interface InformationDetailService {
    public Optional<List<Double>> latitudeLongitudeInfo(String tourName, String cityName);
    public Optional<String> addressInfo(String hotelName,String cityName);
}
