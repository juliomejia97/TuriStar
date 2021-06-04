package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit.Serializable.DomainEventJsonSerializable;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public final class RabbitMqPublisher {
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate template) {
        this.rabbitTemplate = template;
    }

    public void publish(DomainEvent domainEvent, String exchangeName) throws AmqpException {
       String serializedDomainEvent = DomainEventJsonSerializable.serializable(domainEvent);

        Message message = new Message(
                serializedDomainEvent.getBytes(),
                MessagePropertiesBuilder.newInstance()
                        .setContentEncoding("utf-8")
                        .setContentType("application/json").build()
        );
        rabbitTemplate.send(exchangeName,domainEvent.eventName(),message);
    }
}
