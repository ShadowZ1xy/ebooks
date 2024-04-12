package org.zyxi.user.value_objects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jmolecules.ddd.types.ValueObject;

public class EmailAddress implements ValueObject {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", Pattern.CASE_INSENSITIVE);

    private String value;

    public EmailAddress(String value) {
        boolean isValidEmail = isValidEmail(value);
        if (!isValidEmail) {
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
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
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
