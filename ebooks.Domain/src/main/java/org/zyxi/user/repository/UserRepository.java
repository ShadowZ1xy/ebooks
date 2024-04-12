package org.zyxi.user.repository;

import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;


public interface UserRepository {

    void save(UserAggregate user);

    UserAggregate findById(UserId userId);

    default UserAggregate retrieveById(UserId userId) {
        UserAggregate user = findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("can't find user");
        }
        return user;
    }

}
