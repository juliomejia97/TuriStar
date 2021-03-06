package com.webDevelopment.turistar.User.User.Domain;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.TourSpotDetail;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

public class User {

    private UserId userId;
    private UserName userFirstName;
    private UserLastName userLastName;
    private UserEmail userEmail;
    private UserPassword userPassword;
    private Optional<List<HotelPlanBookingDetail>> hotelPlanBookings;
    private Optional<List<TourBookingDetail>> tourBookingDetails;


    public User(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail,
                UserPassword userPassword, List<HotelPlanBookingDetail> hotelPlanBookingDetails,
                List<TourBookingDetail> tourBookingDetails) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.hotelPlanBookings = Optional.ofNullable(hotelPlanBookingDetails);
        this.tourBookingDetails = Optional.ofNullable(tourBookingDetails);
    }
    public static User create(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail,
                        UserPassword userPassword)
    {
        return new User(userId,userFirstName,userLastName,userEmail,userPassword,null,null);
    }

    public boolean authPassword( String userPassword)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        return encoder.matches(userPassword,this.userPassword.value());
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

    public HashMap<String, Object> data()
    {
        return  new HashMap<>() {{
            put("id", userId.value());
            put("name", userFirstName.value());
            put("lastname", userLastName.value());
            put("email", userEmail.value());
            put("tourBookings",dataTourBookings());
        }};
    }

    public Optional<List<HashMap<String, Object>>> dataTourBookings(){
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.tourBookingDetails.isPresent()) {
            response = Optional.of(this.tourBookingDetails.get().stream().map(TourBookingDetail::data)
                    .collect(Collectors.toList()));
        }
        return response;
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

    public void addTourBookings(TourBookingDetail bookingDetail){
        List<TourBookingDetail> tourBookingDetailList = this.tourBookingDetails.isEmpty() ?
                new ArrayList<>():this.tourBookingDetails.get();
        tourBookingDetailList.add(bookingDetail);
        this.tourBookingDetails = Optional.ofNullable(tourBookingDetailList);
    }
}
