package com.webDevelopment.turistar.Hotel.HotelPlan.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.HotelPlan;
import com.webDevelopment.turistar.Hotel.HotelPlan.Domain.Ports.HotelPlanRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ports.TicketRepository;
import com.webDevelopment.turistar.Hotel.Ticket.Domain.Ticket;
import com.webDevelopment.turistar.Shared.Domain.HotelPlan.HotelPlanId;
import com.webDevelopment.turistar.Shared.Domain.Ticket.TicketId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateHotelPlanRepository implements HotelPlanRepository{
    protected final SessionFactory sessionFactory;
    protected final Class<HotelPlan>  aggregateClass;

    public HibernateHotelPlanRepository(@Qualifier("session-factory") SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = HotelPlan.class;
    }

    @Override
    public void update(HotelPlan hotelPlan) {
        sessionFactory.getCurrentSession().update(hotelPlan);
    }

    @Override
    public Optional<HotelPlan> find(String hotelPlantId) {
        HotelPlanId id = new HotelPlanId(hotelPlantId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }


    @Override
    public void save(HotelPlan hotelPlan) {
        sessionFactory.getCurrentSession().save(hotelPlan);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<HotelPlan>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM HotelPlan");
        List<HotelPlan> hotelPlans= query.list();
        return Optional.ofNullable(hotelPlans);
    }
}
