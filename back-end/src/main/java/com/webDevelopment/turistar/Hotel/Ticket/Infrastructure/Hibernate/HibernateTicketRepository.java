package com.webDevelopment.turistar.Hotel.Ticket.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;
import com.webDevelopment.turistar.Shared.Domain.Ticket.TicketId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTicketRepository implements TicketRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Ticket>  aggregateClass;

    public HibernateTicketRepository(@Qualifier("session-factory") SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Ticket.class;
    }

    @Override
    public void update(Ticket ticket) {
        sessionFactory.getCurrentSession().update(ticket);
    }

    @Override
    public Optional<Ticket> find(String ticketId) {
        TicketId id = new TicketId(ticketId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Ticket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Ticket>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Ticket");
        List<Ticket> tickets= query.list();
        return Optional.ofNullable(tickets);
    }
}
