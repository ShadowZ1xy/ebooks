package org.zyxi.infra.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.zyxi.domain.user.value_objects.Role;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "last_update_date_time")
    private LocalDateTime lastUpdateDateTime;

    @Column(name = "resource_id")
    private UUID resourceId;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_entity_id"))
    @Column(name = "role")
    private Collection<Role> roles;

    protected UserEntity() {
    }

    public UserEntity(Long id,
                      LocalDateTime creationDateTime,
                      LocalDateTime lastUpdateDateTime,
                      UUID resourceId,
                      String username,
                      String password,
                      String email,
                      String firstName,
                      String lastName,
                      Collection<Role> roles) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.resourceId = resourceId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }
}
