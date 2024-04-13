package org.infra.user.mapper;

import org.domain.user.UserFactory;
import org.domain.user.value_objects.EmailAddress;
import org.domain.user.value_objects.Name;
import org.domain.user.value_objects.Username;
import org.domain.user.UserAggregate;
import org.infra.user.entity.UserEntity;

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
                new UserAggregate.UserId(user.getUserId()),
                new Username(user.getUsername()),
                user.getPassword(),
                new EmailAddress(user.getEmail()),
                new Name(user.getFirstName()),
                new Name(user.getLastName()),
                user.getRoles()
        );
    }

}
