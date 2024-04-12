package org.zyxi.user_details.repository;

import org.zyxi.user_details.model.CurrentUser;

public interface UserDetailsRepository {
    CurrentUser findByUsername(String username);
}
