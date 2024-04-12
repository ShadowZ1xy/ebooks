package org.zyxi.user;

import org.zyxi.common.Aggregate;
import org.zyxi.common.value_objects.EmailAddress;
import org.zyxi.common.value_objects.Name;
import org.zyxi.common.value_objects.Username;
import org.zyxi.user.value_objects.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class UserAggregate extends Aggregate<UserAggregate, UserId> {

    private UserId userId;
    private Username username;
    private String password;
    private EmailAddress email;
    private Name firstName;
    private Name lastName;
    private Collection<Role> roles;

    public UserAggregate(Username username,
                         String password,
                         EmailAddress email,
                         Name firstName,
                         Name lastName) {
        super();
        validateCreation(username, password, email, firstName, lastName);
        this.userId = new UserId(UUID.randomUUID());
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<>();
    }

    private void validateCreation(Username username, String password, EmailAddress email, Name firstName, Name lastName) {
        if (userId == null) {
            throw new IllegalArgumentException("user creation failed, userId missed");
        }
        if (username == null) {
            throw new IllegalArgumentException("user creation failed, username missed");
        }
        if (password == null) {
            throw new IllegalArgumentException("user creation failed, password missed");
        }
        if (email == null) {
            throw new IllegalArgumentException("user creation failed, email missed");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("user creation failed, firstName missed");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("user creation failed, lastName missed");
        }
    }

    @Override
    public UserId getId() {
        return this.userId;
    }

    public UserAggregate(Long id,
                         LocalDateTime creationDateTime,
                         LocalDateTime lastUpdateDateTime,
                         UserId userId) {

        super(id, creationDateTime, lastUpdateDateTime);
        this.userId = userId;
    }
}
