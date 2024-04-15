package org.zyxi.infra.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyxi.infra.payment.entity.BookPaymentEntity;

import java.util.Optional;
import java.util.UUID;

public interface BookPaymentJpaRepository extends JpaRepository<BookPaymentEntity, Long> {

    Optional<BookPaymentEntity> findByResourceId(UUID resourceId);

}
