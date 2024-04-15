package org.zyxi.infra.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zyxi.infra.user.entity.UserEntity;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserEntity findByResourceId(UUID resourceId);

}
