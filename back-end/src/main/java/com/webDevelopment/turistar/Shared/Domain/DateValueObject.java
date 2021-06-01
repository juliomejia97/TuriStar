package com.webDevelopment.turistar.Shared.Domain;

import java.time.LocalDate;
import java.util.Objects;

public class DateValueObject {
    protected LocalDate value;

    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValueObject that = (DateValueObject) o;
        return Objects.equals(value, that.value);
    }
}
