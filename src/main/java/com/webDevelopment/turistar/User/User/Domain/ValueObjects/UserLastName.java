package com.webDevelopment.turistar.User.User.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.LengthNotValid;

public class UserLastName extends StringValueObject
{
    public UserLastName(){}
    public UserLastName(String value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules
    }

    private void lenghtRule(String value) {
        if (value.length() < 3) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }
}