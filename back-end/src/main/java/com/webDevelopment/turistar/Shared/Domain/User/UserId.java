package com.webDevelopment.turistar.Shared.Domain.User;

import com.webDevelopment.turistar.Shared.Domain.CustomUUID;

public class UserId extends CustomUUID {
    public UserId(String value) {
        super(value);
    }
    private UserId() {
        super();
    }
}