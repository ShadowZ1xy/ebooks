package org.zyxi.common.value_objects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jmolecules.ddd.types.ValueObject;

public class EmailAddress implements ValueObject {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private String value;

    public EmailAddress(String value) {
        boolean isValidEmail = isValidEmail(value);
        if (isValidEmail) {
            throw new IllegalArgumentException("email validation failed");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress address = (EmailAddress) o;
        return Objects.equals(this.value, address.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
