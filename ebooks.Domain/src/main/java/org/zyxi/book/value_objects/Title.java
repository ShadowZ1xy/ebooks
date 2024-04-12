package org.zyxi.book.value_objects;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Title {

    private String value;

    public Title(String value) {
        boolean isValueBlank = StringUtils.isBlank(value);
        if (isValueBlank) {
            throw new IllegalArgumentException("title value can't be empty");
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
        Title title = (Title) o;
        return Objects.equals(value, title.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
