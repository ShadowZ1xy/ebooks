package org.zyxi.user_details.repository;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsRepository {
    UserDetails loadUserByUsername(String username);
}
