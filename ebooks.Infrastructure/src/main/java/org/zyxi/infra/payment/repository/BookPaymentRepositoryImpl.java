package org.zyxi.infra.payment.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.payment.BookPaymentAggregate;
import org.zyxi.domain.payment.repository.BookPaymentRepository;
import org.zyxi.infra.payment.entity.BookPaymentEntity;
import org.zyxi.infra.payment.mapper.BookPaymentMapper;

@Component
@RequiredArgsConstructor
public class BookPaymentRepositoryImpl implements BookPaymentRepository {

    private final BookPaymentJpaRepository repository;

    @Override
    public void save(BookPaymentAggregate bookPayment) {
        BookPaymentEntity bookPaymentEntity = BookPaymentMapper.map(bookPayment);
        bookPaymentEntity.registerEvents(bookPayment.domainEvents());
        repository.save(bookPaymentEntity);
    }

    @Override
    public BookPaymentAggregate retrieve(BookPaymentId bookPaymentId) {
        BookPaymentEntity bookPayment = repository.findByResourceId(bookPaymentId.resourceId())
                .orElseThrow(RuntimeException::new);
        return BookPaymentMapper.map(bookPayment);
    }

}
