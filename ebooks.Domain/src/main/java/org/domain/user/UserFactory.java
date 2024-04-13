package org.domain.user;

import org.domain.user.value_objects.EmailAddress;
import org.domain.user.value_objects.Name;
import org.domain.user.value_objects.Role;
import org.domain.user.value_objects.Username;

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
                                    UserAggregate.UserId userId,
                                    Username username,
                                    String password,
                                    EmailAddress email,
                                    Name firstName,
                                    Name lastName,
                                    Collection<Role> roles) {
        return new UserAggregate(id, creationDateTime, lastUpdateDateTime, userId, username, password, email, firstName, lastName, roles);
    }

}
