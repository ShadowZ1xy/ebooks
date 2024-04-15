package org.zyxi.infra.user_details.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.value_objects.Role;
import org.zyxi.domain.user.value_objects.Username;

import java.util.Collection;
import java.util.stream.Collectors;

public class BaseUser implements UserDetails {

    private UserId userId;

    private Username username;

    private String password;

    private Collection<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username.getValue();
    }

    public UserId getUserId() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public BaseUser(UserId userId,
                    Username username,
                    String password,
                    Collection<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
