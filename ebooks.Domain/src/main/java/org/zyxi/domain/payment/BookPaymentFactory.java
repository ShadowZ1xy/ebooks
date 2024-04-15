package org.zyxi.domain.payment;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;

import java.net.URL;
import java.time.LocalDateTime;

public class BookPaymentFactory {

    public static BookPaymentAggregate create(BookId bookId,
                                              UserId userId,
                                              URL receiptUrl) {
        return new BookPaymentAggregate(bookId, userId, receiptUrl);
    }

    public static BookPaymentAggregate map(Long id,
                                           BookPaymentId resourceId,
                                           LocalDateTime creationDateTime,
                                           LocalDateTime lastUpdateDateTime,
                                           BookPaymentStatus status,
                                           Association<BookAggregate, BookId> bookId,
                                           Association<UserAggregate, UserId> userId,
                                           URL receiptUrl) {
        return new BookPaymentAggregate(id, resourceId, creationDateTime, lastUpdateDateTime, status, bookId, userId, receiptUrl);
    }

}
