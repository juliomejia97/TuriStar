package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Tour.Tour.Domain.Ports.TourRepository;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTourRepository implements TourRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Tour>  aggregateClass;

    public HibernateTourRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Tour.class;
    }

    @Override
    public void update(Tour tour) {
        sessionFactory.getCurrentSession().update(tour);
    }

    @Override
    public Optional<Tour> find(String tourId) {
        TourId id = new TourId(tourId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Tour tour) {
        sessionFactory.getCurrentSession().save(tour);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Tour>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Tour");
        List<Tour> tours = query.list();
        return Optional.ofNullable(tours);
    }
}
