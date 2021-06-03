package com.webDevelopment.turistar.User.User.Infrastructure.Hibernate;


import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateUserRepository implements UserRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<User>  aggregateClass;

    public HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = User.class;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<User> find(String userId) {
        UserId id = new UserId(userId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public Optional<User> findByEmail(String userEmail) {
        /*
        userEmail = "\'" + userEmail + "\'";
        String sqlQuery = "SELECT * FROM users WHERE users.userEmail = " + userEmail ;
        System.out.println( sqlQuery + " la query ");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
        System.out.println(query.setResultTransformer(Transformers.aliasToBean(aggregateClass)) + " Restirno");
        return Optional.ofNullable( (User)query.setResultTransformer(Transformers.aliasToBean(aggregateClass)) );
      */


        return Optional.ofNullable((User) sessionFactory.getCurrentSession().createQuery("from User where userEmail = :userEmail").
                setParameter("userEmail",userEmail).uniqueResult());

    }

}
