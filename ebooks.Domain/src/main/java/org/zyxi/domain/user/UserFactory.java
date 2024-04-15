package org.zyxi.domain.user;

import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.value_objects.EmailAddress;
import org.zyxi.domain.user.value_objects.Name;
import org.zyxi.domain.user.value_objects.Role;
import org.zyxi.domain.user.value_objects.Username;

import java.time.LocalDateTime;
import java.util.Collection;

public class UserFactory {

    public static UserAggregate create(Username username,
                                       String password,
                                       EmailAddress email,
                                       Name firstName,
                                       Name lastName) {
        return new UserAggregate(username, password, email, firstName, lastName);
    }

    public static UserAggregate map(Long id,
                                    LocalDateTime creationDateTime,
                                    LocalDateTime lastUpdateDateTime,
                                    UserId userId,
                                    Username username,
                                    String password,
                                    EmailAddress email,
                                    Name firstName,
                                    Name lastName,
                                    Collection<Role> roles) {
        return new UserAggregate(id, creationDateTime, lastUpdateDateTime, userId, username, password, email, firstName, lastName, roles);
    }

}
