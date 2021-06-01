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

@Transactional("transactional-manager")
public class HibernateCityRepository implements CityRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<City>  aggregateClass;

    public HibernateCityRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = City.class;
    }


    @Override
    public Optional<City> find(String cityId) {
        CityId id = new CityId(cityId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public Optional<List<City>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM City");
        List<City> cities= query.list();
        return Optional.ofNullable(cities);
    }

    @Override
    public void update(City city) {
        this.sessionFactory.getCurrentSession().update(city);
    }
}
