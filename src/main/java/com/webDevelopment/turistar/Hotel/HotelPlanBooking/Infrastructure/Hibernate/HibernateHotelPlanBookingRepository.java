package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("city-transactional-manager")
public class HibernateHotelPlanBookingRepository implements HotelPlanBookingRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<HotelPlanBooking>  aggregateClass;

    public HibernateHotelPlanBookingRepository(@Qualifier("city-session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = HotelPlanBooking.class;
    }

    @Override
    public void update(HotelPlanBooking hotelPlanBooking) {
        sessionFactory.getCurrentSession().update(hotelPlanBooking);
    }

    @Override
    public Optional<HotelPlanBooking> find(String cityId) {
        CityId id = new CityId(cityId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(HotelPlanBooking hotelPlanBooking) {
        sessionFactory.getCurrentSession().save(hotelPlanBooking);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<HotelPlanBooking>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM City");
        List<HotelPlanBooking> cities= query.list();
        return Optional.ofNullable(cities);
    }
}
