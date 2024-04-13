package org.domain.book.value_objects;

import org.apache.commons.lang3.StringUtils;
import org.jmolecules.ddd.types.ValueObject;

import java.util.Objects;

public record Genre(String value) implements ValueObject {

    public Genre {
        boolean isValueBlank = StringUtils.isBlank(value);
        if (isValueBlank) {
            throw new IllegalArgumentException("genre value can't be empty");
        }
        if (value.length() > 30) {
            throw new IllegalArgumentException("genre can't be longer 30 character");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(value, genre.value);
    }

}
