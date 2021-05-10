package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class HotelDetail {
    private String hotelName;
    private Double hotelStars;
    private String hotelAddress;
    HashMap<String, Object> hotelPhotos;

    public HotelDetail(String hotelName, Double hotelStars, String hotelAddress, HashMap<String, Object> hotelPhotos) {
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }

    private HotelDetail(){}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("hotelName", hotelName);
            put("hotelStars", hotelStars);
            put("hotelAddress", hotelAddress);
            put("hotelPhotos", hotelPhotos);
        }};
        return data;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDetail that = (HotelDetail) o;
        return Objects.equals(hotelName, that.hotelName) && Objects.equals(hotelStars, that.hotelStars) && Objects.equals(hotelAddress, that.hotelAddress) && Objects.equals(hotelPhotos, that.hotelPhotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, hotelStars, hotelAddress, hotelPhotos);
    }
}
