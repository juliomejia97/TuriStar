package com.webDevelopment.turistar.User.User.Infrastructure.Hibernate;


import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional("transactional-manager")
public class HibernateUserRepository implements UserRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<User>  aggregateClass;
    private final String SECRET = "web_inventory";
    private final String ID = "inventoryAppToken";
    private final String CLAIM = "authorities";
    private final int validity = 60000;
    private final String PREFIX = "Bearer ";

    public HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = User.class;
    }

    @Override
    public String getToken(String userEmail) throws Exception {
        try {
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
                    commaSeparatedStringToAuthorityList("ROLE_USER");
            String token = Jwts.builder()
                    .setId(ID)
                    .setSubject(userEmail)
                    .claim(CLAIM, grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + validity))
                    .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
            return PREFIX + token;
        }
        catch(Exception e) {
            throw new Exception("UserServiceImpl.getToken Causa: " + e.toString());
        }
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

        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE userEmail = \'"+userEmail+"\'");
        User user= (User) query.uniqueResult();

        return Optional.ofNullable(user);

    }

}
