package org.zyxi.infra.payment.mapper;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.payment.BookPaymentAggregate;
import org.zyxi.domain.payment.BookPaymentFactory;
import org.zyxi.infra.payment.entity.BookPaymentEntity;

public class BookPaymentMapper {

    public static BookPaymentAggregate map(BookPaymentEntity entity) {
        return BookPaymentFactory.map(
                entity.getId(),
                new BookPaymentId(entity.getResourceId()),
                entity.getCreationDateTime(),
                entity.getLastUpdateDateTime(),
                entity.getStatus(),
                Association.forId(new BookId(entity.getBookId())),
                Association.forId(new UserId(entity.getUserId())),
                entity.getReceiptUrl()
        );
    }

    public static BookPaymentEntity map(BookPaymentAggregate aggregate) {
        return new BookPaymentEntity(
                aggregate.getInnerId(),
                aggregate.getCreationDateTime(),
                aggregate.getLastUpdateDateTime(),
                aggregate.getId().resourceId(),
                aggregate.getStatus(),
                aggregate.getUserId().resourceId(),
                aggregate.getBookId().resourceId(),
                aggregate.getReceiptUrl()
        );
    }

}
