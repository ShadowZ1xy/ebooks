package org.zyxi.user_details.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user.value_objects.Username;
import org.zyxi.user.UserId;
import org.zyxi.user_details.entity.UserDetailsEntity;
import org.zyxi.user_details.model.CurrentUser;

@Component
@RequiredArgsConstructor
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private final UserDetailsJpaRepository repository;

    @Override
    public CurrentUser findByUsername(String username) {
        UserDetailsEntity userDetailsEntity = repository.findByUsername(username);
        return new CurrentUser(
                new UserId(userDetailsEntity.getUserId()),
                new Username(userDetailsEntity.getUsername()),
                userDetailsEntity.getPassword(),
                userDetailsEntity.getRoles());
    }
}
