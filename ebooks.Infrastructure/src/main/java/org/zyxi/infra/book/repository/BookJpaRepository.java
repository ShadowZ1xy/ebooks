package org.zyxi.infra.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zyxi.infra.book.entity.BookEntity;

import java.util.UUID;

@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    boolean existsByResourceId(UUID resourceId);

    BookEntity findByResourceId(UUID resourceId);

}
