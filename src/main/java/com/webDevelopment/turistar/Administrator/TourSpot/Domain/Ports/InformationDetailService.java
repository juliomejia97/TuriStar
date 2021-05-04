package com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports;

import java.util.List;
import java.util.Optional;

public interface InformationDetailService {
    public Optional<List<Double>> lantitudeLongitudeInfo(String tourName, String cityName);
}
