package com.webDevelopment.turistar.Shared.Domain.Administrator;

import com.webDevelopment.turistar.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class AdministratorNotifyDomainEvent extends DomainEvent {

    private String email;
    private String message;

    public AdministratorNotifyDomainEvent(String aggregateId, String email, String message) {
        super(aggregateId);
        this.email = email;
        this.message = message;
    }

    public AdministratorNotifyDomainEvent(String aggregateId, String eventId, String occurredOn, String email, String message) {
        super(aggregateId, eventId, occurredOn);
        this.email = email;
        this.message = message;
    }

    private AdministratorNotifyDomainEvent() {
        this.email = null;
        this.message = null;
    }

    @Override
    public String eventName() {
        return "administrator.notify";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("email",email);
            put("message",message);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new AdministratorNotifyDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("email"),
                (String)body.get("message"));
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

}
