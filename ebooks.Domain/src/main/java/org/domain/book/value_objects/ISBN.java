package org.domain.book.value_objects;

import org.jmolecules.ddd.types.ValueObject;

public record ISBN(Integer value) implements ValueObject {

    public ISBN {
        if (value == null) {
            throw new IllegalArgumentException("value value can't be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("value can't be negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ISBN isbn = (ISBN) o;
        return value.equals(isbn.value);
    }

}
