package org.infra.user.repository;

import lombok.RequiredArgsConstructor;
import org.domain.user.repository.UserRepository;
import org.infra.user.entity.UserEntity;
import org.infra.user.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.domain.user.UserAggregate;
import org.domain.user.value_objects.EmailAddress;
import org.domain.user.value_objects.Username;

import static org.domain.user.UserAggregate.*;

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
