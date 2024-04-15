package org.zyxi.domain.payment.event;

import org.zyxi.domain.common.DomainEvent;
import org.zyxi.domain.payment.BookPaymentAggregate;

import java.util.Objects;

public class BookPaymentConfirmedEvent extends DomainEvent {

    private final BookPaymentAggregate aggregate;

    public BookPaymentConfirmedEvent(BookPaymentAggregate aggregate) {
        this.aggregate = Objects.requireNonNull(aggregate, "aggregate must not be null");
    }

    public BookPaymentAggregate get() {
        return aggregate;
    }

}
