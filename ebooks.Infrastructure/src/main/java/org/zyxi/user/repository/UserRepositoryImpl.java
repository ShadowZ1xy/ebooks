package org.zyxi.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public void save(UserAggregate user) {

    }

    @Override
    public UserAggregate findById(UserId userId) {
        return null;
    }

}
