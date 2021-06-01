package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class HotelPlanDetail {

    private String hotelPlanId;
    private double hotelPlanPrice;
    private String hotelPlanDescription;
    private double hotelPlanPeopleNumber;
    private String hotelPlanBookingId;
    private double hotelPlanQuantity;
    //TODO id de hotel
    private boolean hotelPlanActive ;

    private HotelPlanDetail(){}

    public HotelPlanDetail(String hotelPlanId, double hotelPlanPrice, String hotelPlanDescription, double hotelPlanPeopleNumber, String hotelPlanBookingId, double hotelPlanQuantity, boolean hotelPlanActive) {
        this.hotelPlanId = hotelPlanId;
        this.hotelPlanPrice = hotelPlanPrice;
        this.hotelPlanDescription = hotelPlanDescription;
        this.hotelPlanPeopleNumber = hotelPlanPeopleNumber;
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.hotelPlanQuantity = hotelPlanQuantity;
        this.hotelPlanActive = hotelPlanActive;
    }
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", hotelPlanId);
            put("hotelPlanPrice",String.valueOf(hotelPlanPrice));
            put("hotelPlanDescription", hotelPlanDescription);
            put("hotelPlanPeopleNumber", String.valueOf(hotelPlanPeopleNumber));
            put("hotelPlanActive", hotelPlanActive);
            put("hotelPlanBookingId", hotelPlanBookingId);
            put("hotelPlanQuantity", hotelPlanQuantity);
        }};
        return data;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPlanDetail hotelPlan = (HotelPlanDetail) o;
        return  Objects.equals(hotelPlanId, hotelPlan.hotelPlanId) &&
                Objects.equals(hotelPlanDescription, hotelPlan.hotelPlanDescription) &&
                Objects.equals(hotelPlanPrice, hotelPlan.hotelPlanPrice) &&
                Objects.equals(hotelPlanPeopleNumber, hotelPlan.hotelPlanPeopleNumber) &&
                Objects.equals(hotelPlanBookingId, hotelPlan.hotelPlanBookingId) &&
                Objects.equals(hotelPlanQuantity, hotelPlan.hotelPlanQuantity) &&

                Objects.equals(hotelPlanActive, hotelPlan.hotelPlanActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash( hotelPlanId,  hotelPlanPrice,  hotelPlanDescription,  hotelPlanPeopleNumber,  hotelPlanBookingId,  hotelPlanQuantity,  hotelPlanActive);
    }
}
