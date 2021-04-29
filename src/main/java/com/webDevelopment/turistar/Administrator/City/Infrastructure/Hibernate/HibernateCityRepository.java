package com.webDevelopment.turistar.Administrator.City.Infrastructure.Hibernate;

import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional("city-transactional-manager")
public class HibernateCityRepository implements CityRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<City>  aggregateClass;

    public HibernateCityRepository(@Qualifier("city-session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = City.class;
    }

    @Override
    public void update(City city) {
        sessionFactory.getCurrentSession().update(city);
    }

    @Override
    public Optional<City> find(String cityId) {
        CityId id = new CityId(cityId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(City city) {
        sessionFactory.getCurrentSession().save(city);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<City>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM City");
        List<City> cities= query.list();
        return Optional.ofNullable(cities);
    }
}
