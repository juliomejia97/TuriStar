package com.webDevelopment.turistar.Shared.Domain;

import java.util.Objects;

public class StringValueObject {

    protected String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    public String value() {
        return value;
    }
}
