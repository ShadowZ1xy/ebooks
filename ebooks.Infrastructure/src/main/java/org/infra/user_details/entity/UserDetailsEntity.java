package org.infra.user_details.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.domain.user.value_objects.Role;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserDetailsEntity implements UserDetails {

    @Id
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Column(name = "user_id", updatable = false, insertable = false)
    private UUID userId;

    @Column(name = "username", updatable = false, insertable = false)
    private String username;

    @Column(name = "password", updatable = false, insertable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_entity_id"))
    @Column(name = "role", updatable = false, insertable = false)
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
        return username;
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

    public Long getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    protected UserDetailsEntity() {
    }
}
