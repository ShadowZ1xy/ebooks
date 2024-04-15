package org.zyxi.domain.payment.repository;

import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.common.repository.Repository;
import org.zyxi.domain.payment.BookPaymentAggregate;

public interface BookPaymentRepository extends Repository<BookPaymentAggregate, BookPaymentId> {

    BookPaymentAggregate retrieve(BookPaymentId bookPaymentId);

}
