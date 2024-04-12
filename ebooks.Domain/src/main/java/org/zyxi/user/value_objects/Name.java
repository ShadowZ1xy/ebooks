package org.zyxi.user.value_objects;

import org.apache.commons.lang3.StringUtils;
import org.jmolecules.ddd.types.ValueObject;

import java.util.Objects;

public class Name implements ValueObject {

    private String value;

    public Name(String value) {
        boolean isValueBlank = StringUtils.isBlank(value);
        if (isValueBlank) {
            throw new IllegalArgumentException("name value can't be empty");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
