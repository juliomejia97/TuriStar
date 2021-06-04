package com.webDevelopment.turistar.Shared.Intrastructure.Bus.Event.Rabbit.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class DomainEventJsonSerializable {

    public static String serializable(DomainEvent domainEvent){
        HashMap<String, Serializable> attributes = domainEvent.toPrimitive();
        attributes.put("id",domainEvent.aggregateId());

        HashMap<String, Serializable> message = new HashMap<>();

        message.put("data",new HashMap<String,Serializable>(){{
            put("id",domainEvent.eventId());
            put("type",domainEvent.eventName());
            put("occurred_on",domainEvent.occurredOn());
            put("attributes",attributes);
        }});
        message.put("meta",new HashMap<String,Serializable>());
        return jsonEncode(message);
    }

    private static String jsonEncode(HashMap<String,Serializable> map){
        try{
            return new ObjectMapper().writeValueAsString(map);
        }catch (JsonProcessingException ex){
            return "";
        }
    }
}
