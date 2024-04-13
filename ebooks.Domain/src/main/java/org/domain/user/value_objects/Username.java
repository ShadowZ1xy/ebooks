package org.domain.user.value_objects;

import org.apache.commons.lang3.StringUtils;
import org.jmolecules.ddd.types.ValueObject;

import java.util.Objects;

public class Username implements ValueObject {

    private String value;

    public Username(String value) {
        boolean isBlankValue = StringUtils.isBlank(value);
        if (isBlankValue) {
            throw new IllegalArgumentException("username can't be empty");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("username need to be longer then 4 character");
        }
        if (value.length() > 20) {
            throw new IllegalArgumentException("username need to be no longer then 20 character");
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
        Username address = (Username) o;
        return Objects.equals(this.value, address.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
