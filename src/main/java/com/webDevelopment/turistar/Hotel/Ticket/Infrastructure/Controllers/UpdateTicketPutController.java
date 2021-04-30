package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.Ticket.Application.Update.TicketModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hotel/Ticket")
public class UpdateTicketPutController {

    @Autowired
    private TicketModifier ticketModifier;

    @PutMapping(value="/{idTicket}")
    public ResponseEntity<String> execute(@PathVariable String idTicket, @RequestBody Request request){
        ticketModifier.execute(idTicket,request.getTicketAirline(),request.getTicketDeparture(),request.getTicketDestination(),request.getTicketPrice());
        return ResponseEntity.status(HttpStatus.OK).body("Ticket "+ request.getTicketAirline()+" has been modified");
    }

    private static class Request{
        String ticketAirline;
        String ticketDeparture;
        String ticketDestination;
        double ticketPrice;

        public String getTicketAirline() {
            return ticketAirline;
        }
        public void setTicketAirline(String ticketAirline) {
            this.ticketAirline = ticketAirline;
        }

        public String getTicketDeparture() {
            return ticketDeparture;
        }
        public void setTicketDeparture(String ticketDeparture) {
            this.ticketDeparture = ticketDeparture;
        }

        public String getTicketDestination() {
            return ticketDestination;
        }
        public void setTicketDestination(String ticketDestination) {
            this.ticketDestination = ticketDestination;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }
        public void setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
        }
    }

}
