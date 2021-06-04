package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitMqEventBusConfiguration {
    @Autowired
    private Environment en;

    public RabbitMqEventBusConfiguration(Environment en) {
        this.en = en;
    }

    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(en.getProperty("rabbit.host"));
        factory.setPort(Integer.parseInt(en.getProperty("rabbit.port")));
        factory.setUsername(en.getProperty("rabbit.user"));
        factory.setPassword(en.getProperty("rabbit.password"));
        return factory;
    }
}
