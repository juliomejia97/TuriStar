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
    @Bean("session-factory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        //TODO: Cargar Archivos de Configuración sin estar quemados
        FileSystemResource resource1 = new FileSystemResource("./src/main/java/com/webDevelopment/turistar/Administrator/City/Infrastructure/Hibernate/City.hbm.xml");
        FileSystemResource resource2 = new FileSystemResource("./src/main/java/com/webDevelopment/turistar/Tour/Tour/Infrastructure/Hibernate/Tour.hbm.xml");
        FileSystemResource resource3 = new FileSystemResource("./src/main/java/com/webDevelopment/turistar/Hotel/Ticket/Infrastructure/Hibernate/Tickets.hbm.xml");
        FileSystemResource resource4 = new FileSystemResource("./src/main/java/com/webDevelopment/turistar/Administrator/TourSpot/Infrastructure/Hibernate/TourSpot.hbm.xml");
        sessionFactory.setMappingLocations(resource1, resource2, resource3,resource4);
        return sessionFactory;
    }
    @Bean("transactional-manager")
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
