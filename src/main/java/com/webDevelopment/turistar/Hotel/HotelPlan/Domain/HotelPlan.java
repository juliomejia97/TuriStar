package com.webDevelopment.turistar.Hotel.HotelPlan.Domain;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.*;
import com.webDevelopment.turistar.Shared.Domain.HotelPlan.HotelPlanId;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;

import java.util.HashMap;
import java.util.Objects;

public class HotelPlan {

    private HotelPlanId hotelPlanId;
    private HotelPlanPrice hotelPlanPrice;
    private HotelPlanDescription hotelPlanDescription;
    private HotelPlanPeopleNumber hotelPlanPeopleNumber;
    private HotelPlanBookingId hotelPlanBookingId;
    private HotelPlanQuantity hotelPlanQuantity;
    //TODO id de hotel
    private HotelPlanActive hotelPlanActive ;


    private HotelPlan(){}

    public HotelPlan(HotelPlanId hotelPlanId, HotelPlanPrice hotelPlanPrice, HotelPlanDescription hotelPlanDescription,HotelPlanPeopleNumber hotelPlanPeopleNumber,HotelPlanBookingId hotelPlanBookingId,HotelPlanQuantity hotelPlanQuantity) {
        this.hotelPlanId = hotelPlanId;
        this.hotelPlanPrice = hotelPlanPrice;
        this.hotelPlanDescription = hotelPlanDescription;
        this.hotelPlanPeopleNumber = hotelPlanPeopleNumber;
        this.hotelPlanBookingId = hotelPlanBookingId;
        this.hotelPlanQuantity = hotelPlanQuantity;
        this.hotelPlanActive= new HotelPlanActive(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPlan hotelPlan = (HotelPlan) o;
        return Objects.equals(hotelPlanId, hotelPlan.hotelPlanId) &&
                Objects.equals(hotelPlanDescription, hotelPlan.hotelPlanDescription) &&
                Objects.equals(hotelPlanPrice, hotelPlan.hotelPlanPrice) &&
                Objects.equals(hotelPlanPeopleNumber, hotelPlan.hotelPlanPeopleNumber) &&
                Objects.equals(hotelPlanBookingId, hotelPlan.hotelPlanBookingId) &&
                Objects.equals(hotelPlanQuantity, hotelPlan.hotelPlanQuantity) &&

                Objects.equals(hotelPlanActive, hotelPlan.hotelPlanActive);
    }

    public HashMap<String, String> data()
    {
        return new HashMap<>() {{
            put("id", hotelPlanId.value());
            put("hotelPlanPrice",String.valueOf(hotelPlanPrice.value()));
            put("hotelPlanDescription", hotelPlanDescription.value());
            put("hotelPlanPeopleNumber", String.valueOf(hotelPlanPeopleNumber.value()));
            put("hotelPlanActive", hotelPlanActive.value().toString());
            put("hotelPlanBookingId", hotelPlanBookingId.value());
            put("hotelPlanQuantity", hotelPlanQuantity.value().toString());
        }};
    }

    public void updatehotelPlan(String hotelPlanDescription,double hotelPlanPrice,double hotelPlanPeopleNumber) {
        this.hotelPlanPrice = new HotelPlanPrice(hotelPlanPrice);
        this.hotelPlanDescription = new HotelPlanDescription(hotelPlanDescription);
        this.hotelPlanPeopleNumber = new HotelPlanPeopleNumber(hotelPlanPeopleNumber);
    }

    public void deleteHotelPlan(){
        this.hotelPlanActive = new HotelPlanActive(false);
    }

    public boolean equalsbyId(String hotelPlanId){
        return this.hotelPlanId.equals(new HotelPlanId(hotelPlanId));
    }


}
