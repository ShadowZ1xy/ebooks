package org.zyxi.application.book.event.add_owner;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.book.repository.BookRepository;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.payment.event.BookPaymentConfirmedEvent;

@Component
@RequiredArgsConstructor
public class BookPaymentConfirmedEventHandler {

    private final BookRepository bookRepository;

    @EventListener
    public void addOwner(BookPaymentConfirmedEvent event) {
        BookAggregate book = bookRepository.retrieveById(event.get().getBookId());
        UserId userId = event.get().getUserId();
        book.addOwner(userId);
        bookRepository.save(book);
    }

}
