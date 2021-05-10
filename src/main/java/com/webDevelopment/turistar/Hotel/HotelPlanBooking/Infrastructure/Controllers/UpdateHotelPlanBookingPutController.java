package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Application.Update.HotelPlanBookingModifier;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidEndDate;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Exceptions.InvalidInitDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/hotel/HotelPlanBooking")
public class UpdateHotelPlanBookingPutController {

    @Autowired
    private HotelPlanBookingModifier hotelPlanBookingModifier;

    @PutMapping(value="/{idHotelPlanBooking}")
    public ResponseEntity<String> execute(@PathVariable String idHotelPlanBooking, @RequestBody Request request){
        hotelPlanBookingModifier.execute(idHotelPlanBooking, request.hotelPlanBookingInitDate, request.hotelPlanBookingEndDate);
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Plan Booking "+idHotelPlanBooking +" has been modified");
    }

    //TODO: Captura de Excepciones
    @ExceptionHandler(InvalidInitDate.class)
    public ResponseEntity<HashMap> handleDataErrors(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(InvalidEndDate.class)
    public ResponseEntity<HashMap> handleBadInfoHotelPlanBookingId(InvalidEndDate exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    private static class Request{
        private LocalDate hotelPlanBookingInitDate;
        private LocalDate hotelPlanBookingEndDate;

        public LocalDate getHotelPlanBookingInitDate() {
            return hotelPlanBookingInitDate;
        }

        public void setHotelPlanBookingInitDate(LocalDate hotelPlanBookingInitDate) {
            this.hotelPlanBookingInitDate = hotelPlanBookingInitDate;
        }

        public LocalDate getHotelPlanBookingEndDate() {
            return hotelPlanBookingEndDate;
        }

        public void setHotelPlanBookingEndDate(LocalDate hotelPlanBookingEndDate) {
            this.hotelPlanBookingEndDate = hotelPlanBookingEndDate;
        }
    }

}
