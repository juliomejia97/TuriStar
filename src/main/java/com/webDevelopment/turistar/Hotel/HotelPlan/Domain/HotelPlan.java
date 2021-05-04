package com.webDevelopment.turistar.Hotel.HotelPlan.Domain;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanActive;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanDescription;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanPeopleNumber;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.ValueObjects.HotelPlanPrice;
import com.webDevelopment.turistar.Shared.Domain.HotelPlan.HotelPlanId;

import java.util.HashMap;
import java.util.Objects;

public class HotelPlan {

    private HotelPlanId hotelPlanId;
    private HotelPlanPrice hotelPlanPrice;
    private HotelPlanDescription hotelPlanDescription;
    private HotelPlanPeopleNumber hotelPlanPeopleNumber;

    private HotelPlanActive hotelPlanActive ;


    private HotelPlan(){}

    public HotelPlan(HotelPlanId hotelPlanId, HotelPlanPrice hotelPlanPrice, HotelPlanDescription hotelPlanDescription,HotelPlanPeopleNumber hotelPlanPeopleNumber) {
        this.hotelPlanId = hotelPlanId;
        this.hotelPlanPrice = hotelPlanPrice;
        this.hotelPlanDescription = hotelPlanDescription;
        this.hotelPlanPeopleNumber = hotelPlanPeopleNumber;
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
                Objects.equals(hotelPlanActive, hotelPlan.hotelPlanActive);
    }

    public HashMap<String, String> data()
    {
        return new HashMap<>() {{
            put("id", hotelPlanId.value());
            put("hotelPlanPrice",hotelPlanPrice.toString());
            put("hotelPlanDescription", hotelPlanDescription.value());
            put("hotelPlanPeopleNumber", hotelPlanPeopleNumber.toString());
            put("hotelPlanActive", hotelPlanActive.value().toString());
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
