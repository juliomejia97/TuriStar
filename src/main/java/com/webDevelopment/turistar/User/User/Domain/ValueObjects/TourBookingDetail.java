package com.webDevelopment.turistar.User.User.Domain.ValueObjects;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class TourBookingDetail {
    private String tourBookingId;
    private LocalDate tourBookingInitDate;
    private LocalDate tourBookingEndDate;
    private Boolean tourBookingActive;

    public TourBookingDetail(String tourBookingId, LocalDate tourBookingInitDate, LocalDate tourBookingEndDate,
                             Boolean tourBookingActive) {
        this.tourBookingId = tourBookingId;
        this.tourBookingInitDate = tourBookingInitDate;
        this.tourBookingEndDate = tourBookingEndDate;
        this.tourBookingActive = tourBookingActive;
    }

    public HashMap <String,Object> data()
    {
        HashMap <String,Object> data = new HashMap<String,Object>(){{

            put("id", tourBookingId);
            put("initDate", tourBookingInitDate);
            put("endDate", tourBookingEndDate);
            put("isActive", tourBookingActive);

        }};
        return data;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourBookingDetail that = (TourBookingDetail) o;
        return Objects.equals(tourBookingId, that.tourBookingId) && Objects.equals(tourBookingInitDate, that.tourBookingInitDate) && Objects.equals(tourBookingEndDate, that.tourBookingEndDate) && Objects.equals(tourBookingActive, that.tourBookingActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourBookingId, tourBookingInitDate, tourBookingEndDate, tourBookingActive);
    }
    private TourBookingDetail(){}
}
