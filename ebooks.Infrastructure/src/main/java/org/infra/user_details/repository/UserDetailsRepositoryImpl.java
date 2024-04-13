package org.infra.user_details.repository;

import lombok.RequiredArgsConstructor;
import org.infra.user_details.entity.UserDetailsEntity;
import org.infra.user_details.model.BaseUser;
import org.springframework.stereotype.Component;
import org.domain.user.value_objects.Username;

import static org.domain.user.UserAggregate.UserId;

@Component
@RequiredArgsConstructor
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private final UserDetailsJpaRepository repository;

    @Override
    public BaseUser findByUsername(String username) {
        UserDetailsEntity userDetailsEntity = repository.findByUsername(username);
        return new BaseUser(
                new UserId(userDetailsEntity.getUserId()),
                new Username(userDetailsEntity.getUsername()),
                userDetailsEntity.getPassword(),
                userDetailsEntity.getRoles());
    }
}
