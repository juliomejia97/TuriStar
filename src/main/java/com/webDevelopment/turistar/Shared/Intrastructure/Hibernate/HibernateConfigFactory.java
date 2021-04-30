package com.webDevelopment.turistar.Shared.Intrastructure.Hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {
    @Autowired
    private Environment env;
    @Bean("city-session-factory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        //TODO: Cargar el archivo sin ser quemado
        FileSystemResource resource = new FileSystemResource("./src/main/java/com/webDevelopment/turistar/Administrator/City/Infrastructure/Hibernate/City.hbm.xml");
        sessionFactory.setMappingLocations(resource);
        return sessionFactory;
    }
    @Bean("city-transactional-manager")
    public PlatformTransactionManager hibernateTransactionalManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    private DataSource dataSource(){
        String url = env.getProperty("datasource.url");
        String username = env.getProperty("datasource.username");
        String password = env.getProperty("datasource.password");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mariadb://"+url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        return dataSource;
    }
    private Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        return hibernateProperties;
    }
}