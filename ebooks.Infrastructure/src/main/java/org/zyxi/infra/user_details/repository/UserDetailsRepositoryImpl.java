package org.zyxi.infra.user_details.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.value_objects.Username;
import org.zyxi.infra.user_details.entity.UserDetailsEntity;
import org.zyxi.infra.user_details.model.BaseUser;


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
