package com.webDevelopment.turistar.Tour.TourBooking.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Shared.Domain.Tour.TourId;
import com.webDevelopment.turistar.Shared.Domain.TourBooking.TourBookingId;
import com.webDevelopment.turistar.Tour.Tour.Domain.Tour;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.Ports.TourBookingRepository;
import com.webDevelopment.turistar.Tour.TourBooking.Domain.TourBooking;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTourBookingRepository implements TourBookingRepository {


    protected final SessionFactory sessionFactory;
    protected final Class<TourBooking>  aggregateClass;

    public HibernateTourBookingRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = TourBooking.class;
    }

    @Override
    public void update(TourBooking tourBooking) {
        sessionFactory.getCurrentSession().update(tourBooking);
    }

    @Override
    public Optional<TourBooking> find(String tourBookingId) {
        TourBookingId id = new TourBookingId(tourBookingId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(TourBooking tourBooking) {
        sessionFactory.getCurrentSession().save(tourBooking);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }


    @Override
    public Optional<List<TourBooking>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM TourBooking");
        List<TourBooking> tourBookings = query.list();
        return Optional.ofNullable(tourBookings);
    }
}
