package org.domain.book.value_objects;

import org.apache.commons.lang3.StringUtils;
import org.jmolecules.ddd.types.ValueObject;

import java.util.Objects;

public record Text(String value) implements ValueObject {

    public Text {
        boolean isValueBlank = StringUtils.isBlank(value);
        if (isValueBlank) {
            throw new IllegalArgumentException("text value can't be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(value, text.value);
    }

}
