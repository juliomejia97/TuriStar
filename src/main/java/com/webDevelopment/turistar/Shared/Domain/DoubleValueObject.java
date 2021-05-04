package com.webDevelopment.turistar.Shared.Domain;

import java.util.Objects;

public class DoubleValueObject {
    protected Double value;

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValueObject that = (BooleanValueObject) o;
        return Objects.equals(value, that.value);
    }
}
