package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.Ticket.Application.Update.TicketModifier;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketDateDeparture;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketDateReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/hotel/Ticket")
public class UpdateTicketPutController {

    @Autowired
    private TicketModifier ticketModifier;

    @PutMapping(value="/{idTicket}")
    public ResponseEntity<String> execute(@PathVariable String idTicket, @RequestBody Request request){

        ticketModifier.execute(idTicket,request.getHotelPlanBookingId(),request.getAirlineName(),
                request.getTicketDeparture(),request.getTicketDestiantion(),request.getTicketPrice(),
                request.getTicketDateDeparture(),request.getTicketDateReturn());
        return ResponseEntity.status(HttpStatus.OK).body("Ticket "+ request.getAirlineName()+" has been modified");
    }

    private static class Request{

        String airlineName;
        String ticketDeparture;
        String ticketDestiantion;
        String hotelPlanBookingId;
        double ticketPrice;
        LocalDate ticketDateDeparture;
        LocalDate ticketDateReturn;

        public String getAirlineName() {
            return airlineName;
        }

        public void setAirlineName(String airlineName) {
            this.airlineName = airlineName;
        }

        public String getTicketDestiantion() {
            return ticketDestiantion;
        }

        public void setTicketDestiantion(String ticketDestiantion) {
            this.ticketDestiantion = ticketDestiantion;
        }

        public String getTicketDeparture() {
            return ticketDeparture;
        }

        public void setTicketDeparture(String ticketDeparture) {
            this.ticketDeparture = ticketDeparture;
        }


        public String getHotelPlanBookingId() {
            return hotelPlanBookingId;
        }

        public void setHotelPlanBookingId(String hotelPlanBookingId) {
            this.hotelPlanBookingId = hotelPlanBookingId;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
        }

        public LocalDate getTicketDateDeparture() {
            return ticketDateDeparture;
        }

        public void setTicketDateDeparture(LocalDate ticketDateDeparture) {
            this.ticketDateDeparture = ticketDateDeparture;
        }

        public LocalDate getTicketDateReturn() {
            return ticketDateReturn;
        }

        public void setTicketDateReturn(LocalDate ticketDateReturn) {
            this.ticketDateReturn = ticketDateReturn;
        }
    }

}
