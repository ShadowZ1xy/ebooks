package org.zyxi.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user.value_objects.EmailAddress;
import org.zyxi.user.value_objects.Username;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;
import org.zyxi.user.entity.UserEntity;
import org.zyxi.user.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public void save(UserAggregate user) {
        UserEntity entity = UserMapper.map(user);
        repository.save(entity);
    }

    @Override
    public boolean existsByUsername(Username username) {
        return repository.existsByUsername(username.getValue());
    }

    @Override
    public boolean existsByEmail(EmailAddress email) {
        return repository.existsByEmail(email.getValue());
    }

    @Override
    public UserAggregate retrieve(UserId userId) {
        UserEntity user = repository.findByUserId(userId.resourceId())
                .orElseThrow(() -> new RuntimeException());
        return UserMapper.map(user);
    }

}
