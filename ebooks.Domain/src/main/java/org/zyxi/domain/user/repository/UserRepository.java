package org.zyxi.domain.user.repository;

import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.common.repository.Repository;
import org.zyxi.domain.user.UserAggregate;
import org.zyxi.domain.user.value_objects.EmailAddress;
import org.zyxi.domain.user.value_objects.Username;


public interface UserRepository extends Repository<UserAggregate, UserId> {

    void save(UserAggregate user);

    boolean existsByUsername(Username username);

    boolean existsByEmail(EmailAddress email);

    UserAggregate retrieve(UserId userId);

}
