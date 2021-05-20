package com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class HotelDetail {
    private String hotelId;
    private String hotelName;
    private Double hotelStars;
    private String hotelAddress;
    List<HashMap<String, Object>> hotelPhotos;

    public HotelDetail(String hotelId,String hotelName, Double hotelStars, String hotelAddress, List<HashMap<String, Object>> hotelPhotos) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelAddress = hotelAddress;
        this.hotelPhotos = hotelPhotos;
    }

    private HotelDetail(){}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("hotelId",hotelId);
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
        return Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(hotelName, that.hotelName) &&
                Objects.equals(hotelStars, that.hotelStars) &&
                Objects.equals(hotelAddress, that.hotelAddress) &&
                Objects.equals(hotelPhotos, that.hotelPhotos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelName, hotelStars, hotelAddress, hotelPhotos);
    }

    public boolean hotelDetailEqualsById(String hotelId){
        return this.hotelId.equals(hotelId);
    }
}
