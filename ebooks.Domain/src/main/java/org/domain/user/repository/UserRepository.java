package org.domain.user.repository;

import org.domain.user.UserAggregate;
import org.jmolecules.ddd.types.Repository;
import org.domain.user.value_objects.EmailAddress;
import org.domain.user.value_objects.Username;


public interface UserRepository extends Repository<UserAggregate, UserAggregate.UserId> {

    void save(UserAggregate user);

    boolean existsByUsername(Username username);

    boolean existsByEmail(EmailAddress email);

    UserAggregate retrieve(UserAggregate.UserId userId);

}
