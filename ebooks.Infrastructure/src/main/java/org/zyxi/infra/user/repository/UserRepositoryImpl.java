package org.zyxi.infra.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;
import org.zyxi.domain.user.repository.UserRepository;
import org.zyxi.domain.user.value_objects.EmailAddress;
import org.zyxi.domain.user.value_objects.Username;
import org.zyxi.infra.user.entity.UserEntity;
import org.zyxi.infra.user.mapper.UserMapper;

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
        UserEntity userEntity = repository.findByResourceId(userId.resourceId());
        if (userEntity == null) {
            throw new RuntimeException("user doesn't exists");
        }
        return UserMapper.map(userEntity);
    }

}
