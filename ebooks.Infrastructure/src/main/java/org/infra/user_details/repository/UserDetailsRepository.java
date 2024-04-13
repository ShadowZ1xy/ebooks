package org.infra.user_details.repository;

import org.infra.user_details.model.BaseUser;

public interface UserDetailsRepository {
    BaseUser findByUsername(String username);
}
