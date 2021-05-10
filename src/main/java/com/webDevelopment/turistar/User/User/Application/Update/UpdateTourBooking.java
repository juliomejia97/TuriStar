package com.webDevelopment.turistar.User.User.Application.Update;

import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.TourBookingDetail;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateTourBooking {
    private UserRepository repository;

    public UpdateTourBooking(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(String userId, String tourBookingId, LocalDate tourBookingInitDate,
                        LocalDate tourBookingEndDate,Boolean tourBookingActive) {
        Optional<User> userOptional = repository.find(userId);
        if(userOptional.isEmpty()){
            throw new UserNotExist("The user does not exists");
        }
        User finalUser = userOptional.get();
        finalUser.addTourBookings(new TourBookingDetail(tourBookingId,tourBookingInitDate,tourBookingEndDate,tourBookingActive));
        this.repository.update(finalUser);
    }
}
