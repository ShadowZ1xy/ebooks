package org.zyxi.domain.user;

import org.zyxi.domain.common.Aggregate;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.value_objects.EmailAddress;
import org.zyxi.domain.user.value_objects.Name;
import org.zyxi.domain.user.value_objects.Role;
import org.zyxi.domain.user.value_objects.Username;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class UserAggregate extends Aggregate<UserAggregate, UserId> {

    private Username username;
    private String password;
    private EmailAddress email;
    private Name firstName;
    private Name lastName;
    private Collection<Role> roles;

    UserAggregate(Username username,
                  String password,
                  EmailAddress email,
                  Name firstName,
                  Name lastName) {
        super(new UserId(UUID.randomUUID()));
        validateCreation(username, password, email, firstName, lastName);
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<>(List.of(Role.ROLE_USER));
    }

    public void addRole(Role role) {
        if (role == null) {
            throw new RuntimeException("role is null");
        }
        if (roles.contains(role)) {
            throw new RuntimeException("role already assigned");
        }
        roles.add(role);
    }

    public void removeRole(Role role) {
        if (role == null) {
            throw new RuntimeException("role is null");
        }
        if (!roles.contains(role)) {
            throw new RuntimeException("role is not assigned");
        }
        roles.remove(role);
    }

    public void changeName(Name name) {
        if (name == null) {
            throw new RuntimeException("name is null");
        }
        this.firstName = name;
    }

    private void validateCreation(Username username, String password, EmailAddress email, Name firstName, Name lastName) {
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

    public Username getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    UserAggregate(Long id,
                  LocalDateTime creationDateTime,
                  LocalDateTime lastUpdateDateTime,
                  UserId userId,
                  Username username,
                  String password,
                  EmailAddress email,
                  Name firstName,
                  Name lastName,
                  Collection<Role> roles) {
        super(id, userId, creationDateTime, lastUpdateDateTime);
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

}
