package com.webDevelopment.turistar.User.User.Domain.ValueObjects;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TourBookingDetail {
    private String tourBookingId;
    private String tourBookingInitDate;
    private String tourBookingEndDate;

    public TourBookingDetail(String tourBookingId, String tourBookingInitDate, String tourBookingEndDate) {
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
    }

    public HashMap <String,Object> data()
    {
        HashMap <String,Object> data = new HashMap<String,Object>(){{

            put("id", tourBookingId);
            put("initDate", tourBookingInitDate);
            put("endDate", tourBookingEndDate);

        }};
        return data;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourBookingDetail that = (TourBookingDetail) o;
        return Objects.equals(tourBookingId, that.tourBookingId) &&
                Objects.equals(tourBookingInitDate, that.tourBookingInitDate) &&
                Objects.equals(tourBookingEndDate, that.tourBookingEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourBookingId, tourBookingInitDate, tourBookingEndDate);
    }
    private TourBookingDetail(){}
}
