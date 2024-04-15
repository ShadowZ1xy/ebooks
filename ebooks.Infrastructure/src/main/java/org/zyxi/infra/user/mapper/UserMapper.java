package org.zyxi.infra.user.mapper;

import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;
import org.zyxi.domain.user.UserFactory;
import org.zyxi.domain.user.value_objects.EmailAddress;
import org.zyxi.domain.user.value_objects.Name;
import org.zyxi.domain.user.value_objects.Username;
import org.zyxi.infra.user.entity.UserEntity;

public class UserMapper {

    public static UserEntity map(UserAggregate user) {
        return new UserEntity(
                user.getInnerId(),
                user.getCreationDateTime(),
                user.getLastUpdateDateTime(),
                user.getId().resourceId(),
                user.getUsername().getValue(),
                user.getPassword(),
                user.getEmail().getValue(),
                user.getFirstName().getValue(),
                user.getLastName().getValue(),
                user.getRoles()
        );
    }

    public static UserAggregate map(UserEntity user) {
        return UserFactory.map(
                user.getId(),
                user.getCreationDateTime(),
                user.getLastUpdateDateTime(),
                new UserId(user.getResourceId()),
                new Username(user.getUsername()),
                user.getPassword(),
                new EmailAddress(user.getEmail()),
                new Name(user.getFirstName()),
                new Name(user.getLastName()),
                user.getRoles()
        );
    }

}
