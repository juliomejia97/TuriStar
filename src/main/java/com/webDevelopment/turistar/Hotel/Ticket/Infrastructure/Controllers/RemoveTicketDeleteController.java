package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.Ticket.Application.Delete.TicketDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/Ticket")
public class RemoveTicketDeleteController {

    @Autowired
    private TicketDelete ticketDeleter;

    @DeleteMapping(value="/{idTicket}")
    public ResponseEntity<String> execute(@PathVariable String idTicket){
        ticketDeleter.execute(idTicket);
        return ResponseEntity.status(HttpStatus.OK).body("Ticket "+ idTicket +" has been deleted");
    }
}
