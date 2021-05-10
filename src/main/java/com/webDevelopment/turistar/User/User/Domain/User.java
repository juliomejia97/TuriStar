package com.webDevelopment.turistar.User.User.Domain;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.*;

import javax.swing.text.html.Option;
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
    private Optional<List<HotelPlanBooking>> hotelPlanBookings;
    private Optional<List<TourBooking>> tourBookings;
    private Optional<List<Screen>> screens;

    public User(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail,
                UserPassword userPassword, List<HotelPlanBooking> hotelPlanBookings,
                List<TourBooking> tourBookings, List<Screen> screens) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.hotelPlanBookings = Optional.ofNullable(hotelPlanBookings);
        this.tourBookings = Optional.ofNullable(tourBookings);
        this.screens = Optional.ofNullable(screens);
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

    public void setHotelPlanBookings(List<HotelPlanBooking> hotelPlanBookings) {
        this.hotelPlanBookings = Optional.ofNullable(hotelPlanBookings);
    }

    public Optional<List<HashMap<String, Object>>> getTourBookings() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.tourBookings.isPresent()) {
            response = Optional.of(this.tourBookings.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void setTourBookings(List<TourBooking> tourBookings) {
        this.tourBookings = Optional.ofNullable(tourBookings);
    }

    public Optional<List<HashMap<String, Object>>> getScreens() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.screens.isPresent()) {
            response = Optional.of(this.screens.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }


    public void setScreens(List<Screen> screens) {
        this.screens = Optional.ofNullable(screens);
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

}
