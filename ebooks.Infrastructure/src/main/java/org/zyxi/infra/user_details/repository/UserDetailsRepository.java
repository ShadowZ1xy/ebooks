package org.zyxi.infra.user_details.repository;

import org.zyxi.infra.user_details.model.BaseUser;

public interface UserDetailsRepository {
    BaseUser findByUsername(String username);
}
