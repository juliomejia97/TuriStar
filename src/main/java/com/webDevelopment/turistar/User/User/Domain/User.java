package com.webDevelopment.turistar.User.User.Domain;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {

    private UserId userId;
    private UserName userFirstName;
    private UserLastName userLastName;
    private UserEmail userEmail;
    private UserPassword userPassword;
    private Optional<List<HotelPlanBookingDetail>> hotelPlanBookings;
    private Optional<List<TourBookingDetail>> tourBookingDetails;
    private Optional<List<ScreenDetail>> screenDetails;


    public User(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail,
                UserPassword userPassword, List<HotelPlanBookingDetail> hotelPlanBookingDetails,
                List<TourBookingDetail> tourBookingDetails, List<ScreenDetail> screenDetails) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.hotelPlanBookings = Optional.ofNullable(hotelPlanBookingDetails);
        this.tourBookingDetails = Optional.ofNullable(tourBookingDetails);
        this.screenDetails = Optional.ofNullable(screenDetails);
    }
    public static User create(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail,
                        UserPassword userPassword)
    {
        return new User(userId,userFirstName,userLastName,userEmail,userPassword,null,null,null);
    }

    public void updateUser(UserName userFirstName, UserLastName userLastName, UserEmail userEmail)
    {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
    }

    public boolean equalsById(String otherId)
    {
        return this.userId.equals(new UserId(otherId));
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", userId.value());
            put("name", userFirstName.value());
            put("lastname", userLastName.value());
            put("email", userEmail.value());
        }};
        return data;
    }

    public Optional<List<HashMap<String, Object>>> getHotelPlanBookings() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.hotelPlanBookings.isPresent()) {
            response = Optional.of(this.hotelPlanBookings.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void setHotelPlanBookings(List<HotelPlanBookingDetail> hotelPlanBookingDetails) {
        this.hotelPlanBookings = Optional.ofNullable(hotelPlanBookingDetails);
    }

    public Optional<List<HashMap<String, Object>>> getTourBookings() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.tourBookingDetails.isPresent()) {
            response = Optional.of(this.tourBookingDetails.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void setTourBookings(List<TourBookingDetail> tourBookingDetails) {
        this.tourBookingDetails = Optional.ofNullable(tourBookingDetails);
    }

    public Optional<List<HashMap<String, Object>>> getScreens() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.screenDetails.isPresent()) {
            response = Optional.of(this.screenDetails.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }


    public void setScreens(List<ScreenDetail> screenDetails) {
        this.screenDetails = Optional.ofNullable(screenDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userPassword, user.userPassword);
    }
    public User(){}
}
