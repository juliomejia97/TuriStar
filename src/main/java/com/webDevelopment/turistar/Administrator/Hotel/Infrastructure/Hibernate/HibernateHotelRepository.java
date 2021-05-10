package com.webDevelopment.turistar.Administrator.Hotel.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Administrator.Hotel.Domain.Hotel;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.Ports.HotelRepository;
import com.webDevelopment.turistar.Administrator.TourSpot.Domain.TourSpot;
import com.webDevelopment.turistar.Shared.Domain.Hotel.HotelId;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateHotelRepository implements HotelRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Hotel>  aggregateClass;

    public HibernateHotelRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Hotel.class;
    }

    @Override
    public void update(Hotel hotel) {
        this.sessionFactory.getCurrentSession().update(hotel);
    }

    @Override
    public Optional<Hotel> find(String hotelId) {
        HotelId id = new HotelId(hotelId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Hotel hotel) {
        sessionFactory.getCurrentSession().save(hotel);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Hotel>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Hotel");
        return Optional.ofNullable(query.list());
    }
}
