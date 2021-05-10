package com.webDevelopment.turistar.User.User.Domain.ValueObjects;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class HotelPlanBookingDetail {
    private String hotelPlanBookingId;
    private LocalDate hotelPlanBookingInitDate;
    private LocalDate hotelPlanBookingEndDate;

    public HotelPlanBookingDetail(String hotelPlanBookingId, LocalDate hotelPlanBookingInitDate,
                                  LocalDate hotelPlanBookingEndDate) {
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
    }

    public HashMap<String,Object> data()
    {
        HashMap <String,Object> data = new HashMap<String,Object>(){{

            put("id", hotelPlanBookingId);
            put("initDate", hotelPlanBookingInitDate);
            put("endDate", hotelPlanBookingEndDate);

        }};
        return data;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPlanBookingDetail that = (HotelPlanBookingDetail) o;
        return Objects.equals(hotelPlanBookingId, that.hotelPlanBookingId) && Objects.equals(hotelPlanBookingInitDate, that.hotelPlanBookingInitDate) && Objects.equals(hotelPlanBookingEndDate, that.hotelPlanBookingEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelPlanBookingId, hotelPlanBookingInitDate, hotelPlanBookingEndDate);
    }

    private HotelPlanBookingDetail(){}
}
