package com.webDevelopment.turistar.User.User.Domain.ValueObjects;

import com.webDevelopment.turistar.Shared.Domain.StringValueObject;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.EmailNotValid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmail extends StringValueObject
{
    public static final String regex = "^(.+)@(.+)$";
    public UserEmail(String value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.emailRule(value);
        //TODO: Other Rules
    }

    private void emailRule(String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new EmailNotValid("Number of characters invalid");
        }
    }
}