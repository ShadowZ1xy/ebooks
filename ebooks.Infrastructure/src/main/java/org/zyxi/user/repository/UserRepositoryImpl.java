package org.zyxi.user.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;

@Component
@AllArgsConstructor
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
