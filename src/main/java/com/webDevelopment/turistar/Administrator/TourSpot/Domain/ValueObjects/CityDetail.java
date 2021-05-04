package com.webDevelopment.turistar.Administrator.TourSpot.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class CityDetail {

    private String cityDetailId;
    private String cityName;
    private String cityCountry;
    private Boolean cityActive ;

    public CityDetail(String cityDetailId, String cityName, String cityCountry, Boolean cityActive) {
        this.cityDetailId = cityDetailId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.cityActive = cityActive;
    }

    private CityDetail() {
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", cityDetailId);
            put("name", cityName);
            put("country",cityCountry);
            put("active",cityActive);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDetail that = (CityDetail) o;
        return Objects.equals(cityDetailId, that.cityDetailId) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(cityCountry,that.cityCountry) &&
                Objects.equals(cityActive,that.cityActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityDetailId, cityName, cityCountry,cityActive);
    }

}
