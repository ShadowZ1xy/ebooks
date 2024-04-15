package org.zyxi.infra.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zyxi.infra.book.entity.AuthorEntity;

import java.util.UUID;

@Repository
public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {

    AuthorEntity findByName(String name);

    AuthorEntity findByResourceId(UUID resourceId);

}
