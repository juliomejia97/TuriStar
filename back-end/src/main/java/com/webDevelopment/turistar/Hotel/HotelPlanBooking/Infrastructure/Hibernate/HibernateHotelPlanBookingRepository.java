package com.webDevelopment.turistar.Hotel.HotelPlanBooking.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.HotelPlanBooking;
import com.webDevelopment.turistar.Hotel.HotelPlanBooking.Domain.Ports.HotelPlanBookingRepository;
import com.webDevelopment.turistar.Shared.Domain.HotelPlanBooking.HotelPlanBookingId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateHotelPlanBookingRepository implements HotelPlanBookingRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<HotelPlanBooking>  aggregateClass;

    public HibernateHotelPlanBookingRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = HotelPlanBooking.class;
    }

    @Override
    public void update(HotelPlanBooking hotelPlanBooking) {
        sessionFactory.getCurrentSession().update(hotelPlanBooking);
    }

    @Override
    public Optional<HotelPlanBooking> find(String hotelPlanBookingId) {
        HotelPlanBookingId id = new HotelPlanBookingId(hotelPlanBookingId);
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
        Query query = sessionFactory.getCurrentSession().createQuery("FROM HotelPlanBooking");
        List<HotelPlanBooking> hotelPlanBookings = query.list();
        return Optional.ofNullable(hotelPlanBookings);
    }
}
