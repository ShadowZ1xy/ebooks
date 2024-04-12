package org.zyxi.user.repository;

import org.zyxi.user.value_objects.EmailAddress;
import org.zyxi.user.value_objects.Username;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;


public interface UserRepository {

    void save(UserAggregate user);

    boolean existsByUsername(Username username);

    boolean existsByEmail(EmailAddress email);

    UserAggregate retrieve(UserId userId);

}
