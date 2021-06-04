package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Tour.TourBooking.Application.Create.TourBookingCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CreateTourBookingPostController {

    @Autowired
    private TourBookingCreator creator;

    @PostMapping(value = "/TourBooking/")
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getTourBookingId(), request.getTourBookingInitDate(), request.getTourBookingEndDate(), request.getTourId(), request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> TourException(RuntimeException exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class Request {
        private String tourBookingId;
        private LocalDate tourBookingInitDate;
        private LocalDate tourBookingEndDate;
        private String tourId;
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setTourBookingEndDate(LocalDate tourBookingEndDate) {
            this.tourBookingEndDate = tourBookingEndDate;
        }

        public String getTourId() {
            return tourId;
        }

        public void setTourId(String tourId) {
            this.tourId = tourId;
        }

        public String getTourBookingId() {
            return tourBookingId;
        }

        public void setTourBookingId(String tourBookingId) {
            this.tourBookingId = tourBookingId;
        }

        public LocalDate getTourBookingInitDate() {
            return tourBookingInitDate;
        }

        public void setTourBookingInitDate(LocalDate tourBookingInitDate) {
            this.tourBookingInitDate = tourBookingInitDate;
        }

        public LocalDate getTourBookingEndDate() {
            return tourBookingEndDate;
        }

    }
}
