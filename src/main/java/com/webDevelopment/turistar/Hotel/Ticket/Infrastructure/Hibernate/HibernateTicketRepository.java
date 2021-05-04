package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("hotel-transactional-manager")
public class HibernateTicketRepository implements TicketRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Ticket>  aggregateClass;

    public HibernateTicketRepository(@Qualifier("hotel-session-factory") SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Ticket.class;
    }

    @Override
    public void update(String ticketId, Ticket ticket) {

    }

    @Override
    public Optional<Ticket> find(String ticketId) {
        return Optional.empty();
    }

    @Override
    public void save(Ticket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Ticket>> all() {
        return Optional.empty();
    }
}
