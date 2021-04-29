package com.webDevelopment.turistar.Shared.Domain.Ticket;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class TicketId extends CustomUUID {

    public TicketId(String value) {
        super(value);
    }

    private TicketId(){
        super("");
    }
}
