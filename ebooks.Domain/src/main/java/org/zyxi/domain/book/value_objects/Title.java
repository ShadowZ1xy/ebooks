package org.zyxi.domain.book.value_objects;

import org.apache.commons.lang3.StringUtils;
import org.jmolecules.ddd.types.ValueObject;

import java.util.Objects;

public record Title(String value) implements ValueObject {

    public Title {
        boolean isValueBlank = StringUtils.isBlank(value);
        if (isValueBlank) {
            throw new IllegalArgumentException("title value can't be empty");
        }
        if (value.length() > 30) {
            throw new IllegalArgumentException("title can't be longer 30 character");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(value, title.value);
    }

}
