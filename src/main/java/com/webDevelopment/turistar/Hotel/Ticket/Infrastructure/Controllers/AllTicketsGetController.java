package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Controllers;

import com.webDevelopment.turistar.Hotel.Ticket.Application.All.TicketsAll;
import com.webDevelopment.turistar.Hotel.Ticket.Application.All.TicketsAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class AllTicketsGetController {

    @Autowired
    private TicketsAll ticketsAll;

    @GetMapping(value="/Ticket/")
    public ResponseEntity<List<HashMap<String,String>>> execute(){
        TicketsAllResponse response = new TicketsAllResponse(ticketsAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
