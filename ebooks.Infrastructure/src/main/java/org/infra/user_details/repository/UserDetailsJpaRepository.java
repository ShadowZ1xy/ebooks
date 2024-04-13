package org.infra.user_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.infra.user_details.entity.UserDetailsEntity;

@Repository
public interface UserDetailsJpaRepository extends JpaRepository<UserDetailsEntity, Long> {
    UserDetailsEntity findByUsername(String username);
}
