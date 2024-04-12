package org.zyxi.user.mapper;

import org.zyxi.user.value_objects.EmailAddress;
import org.zyxi.user.value_objects.Name;
import org.zyxi.user.value_objects.Username;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;
import org.zyxi.user.entity.UserEntity;

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
        return new UserAggregate(
                user.getId(),
                user.getCreationDateTime(),
                user.getLastUpdateDateTime(),
                new UserId(user.getUserId()),
                new Username(user.getUsername()),
                user.getPassword(),
                new EmailAddress(user.getEmail()),
                new Name(user.getFirstName()),
                new Name(user.getLastName()),
                user.getRoles()
        );
    }

}
