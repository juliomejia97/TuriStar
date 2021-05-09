package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketAirline;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketDeparture;
import com.webDevelopment.turistar.Shared.Domain.Ticket.TicketId;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketDestination;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.ValueObjects.TicketPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTicketRepository implements TicketRepository {

//    private Ticket ticket1 = new Ticket(new TicketId("a0619482-a621-11eb-bcbc-0242ac130002"), new TicketAirline("Viva"),new TicketDeparture("Bogota"),new TicketDestination("Colombia"),new TicketPrice((double) 40000));
//    private Ticket ticket2 = new Ticket(new TicketId("a06197e8-a621-11eb-bcbc-0242ac130002"), new TicketAirline("Despe"),new TicketDeparture("Medellin"),new TicketDestination("Colombia"),new TicketPrice((double) 50000));
//    private Ticket ticket3 = new Ticket(new TicketId("a06198e2-a621-11eb-bcbc-0242ac130002"), new TicketAirline("Aviancas"),new TicketDeparture("Cartagena"),new TicketDestination("Colombia"),new TicketPrice((double) 50000));
    private List<Ticket> cites = new ArrayList<>(){{
//        add(ticket1);
//        add(ticket2);
//        add(ticket3);
    }};

    @Override
    public void update(String cityId, Ticket ticket) {
        Optional<Ticket> cityToupdate = find(cityId);
        cityToupdate.ifPresent(value -> this.cites.remove(value));
        this.cites.add(ticket);
    }

    @Override
    public Optional<Ticket> find(String cityId) {
        return cites.stream().filter(city -> city.equalsbyId(cityId)).findFirst();
    }

    @Override
    public void save(Ticket ticket) {
        this.cites.add(ticket);
    }

    @Override
    public Optional<List<Ticket>> all() {

        return Optional.ofNullable(this.cites);
    }
}
