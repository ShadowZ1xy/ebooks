package org.zyxi.domain.payment;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.common.Aggregate;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.payment.event.BookPaymentConfirmedEvent;
import org.zyxi.domain.user.UserAggregate;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static org.zyxi.domain.payment.BookPaymentStatus.*;

public class BookPaymentAggregate extends Aggregate<BookPaymentAggregate, BookPaymentId> {

    private BookPaymentStatus status;

    private Association<BookAggregate, BookId> bookId;

    private Association<UserAggregate, UserId> userId;

    private URL receiptUrl;

    BookPaymentAggregate(BookId bookId,
                         UserId userId,
                         URL receiptUrl) {
        super(new BookPaymentId(UUID.randomUUID()));
        Objects.requireNonNull(bookId, "bookId must not be null");
        this.bookId = Association.forId(bookId);
        Objects.requireNonNull(userId, "userId must not be null");
        this.userId = Association.forId(userId);
        this.status = REQUESTED;
        this.receiptUrl = Objects.requireNonNull(receiptUrl, "receiptUrl must not be null");
    }

    public void confirm() {
        this.status = CONFIRMED;
        registerEvent(new BookPaymentConfirmedEvent(this));
    }

    public void decline() {
        this.status = DECLINED;
    }

    public BookPaymentStatus getStatus() {
        return status;
    }

    public BookId getBookId() {
        return bookId.getId();
    }

    public UserId getUserId() {
        return userId.getId();
    }

    public URL getReceiptUrl() {
        return receiptUrl;
    }

    BookPaymentAggregate(Long id,
                         BookPaymentId resourceId,
                         LocalDateTime creationDateTime,
                         LocalDateTime lastUpdateDateTime,
                         BookPaymentStatus status,
                         Association<BookAggregate, BookId> bookId,
                         Association<UserAggregate, UserId> userId,
                         URL receiptUrl) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
        this.status = status;
        this.bookId = bookId;
        this.userId = userId;
        this.receiptUrl = receiptUrl;
    }

}
