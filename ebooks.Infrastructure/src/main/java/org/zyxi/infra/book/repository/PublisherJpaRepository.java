package org.zyxi.infra.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zyxi.infra.book.entity.PublisherEntity;

import java.util.UUID;

@Repository
public interface PublisherJpaRepository extends JpaRepository<PublisherEntity, Long> {

    PublisherEntity findByName(String name);

    PublisherEntity findByResourceId(UUID resourceId);

}
