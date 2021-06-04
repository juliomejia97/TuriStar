package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.EventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.core.env.Environment;

import java.util.List;

public class RabbitMqEventBus implements EventBus {

    private final RabbitMqPublisher publisher;
    private final String exchangeName;
    private Environment env;

    public RabbitMqEventBus(RabbitMqPublisher publisher,Environment env) {
        this.publisher = publisher;
        this.env = env;
        this.exchangeName = env.getProperty("rabbit.exchange");
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent){
        try{
            this.publisher.publish(domainEvent,this.exchangeName);
        }catch (AmqpException e){
            System.err.println("Error Publicando: "+e.toString());
            //TODO: Implementar un Failover de Rabbit
        }
    }
}
