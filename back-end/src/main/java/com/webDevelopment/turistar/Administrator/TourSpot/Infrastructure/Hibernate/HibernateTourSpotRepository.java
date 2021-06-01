package com.webDevelopment.turistar.Administrator.TourSpot.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Administrator.TourSpot.Domain.Ports.TourSpotRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTourSpotRepository implements TourSpotRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<TourSpot>  aggregateClass;

    public HibernateTourSpotRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = TourSpot.class;
    }
    @Override
    public void update(TourSpot tourSpot) {
        this.sessionFactory.getCurrentSession().update(tourSpot);
    }

    @Override
    public Optional<TourSpot> find(String tourId) {
        TourSpotId id = new TourSpotId(tourId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(TourSpot tourSpot) {
        sessionFactory.getCurrentSession().save(tourSpot);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<TourSpot>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From TourSpot");
        return Optional.ofNullable(query.list());
    }
}
