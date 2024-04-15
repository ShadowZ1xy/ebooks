package org.zyxi.application.payment.pipeline.buy_book;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.application.common.service.CurrentUserProviderService;
import org.zyxi.domain.book.repository.BookRepository;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.payment.BookPaymentAggregate;
import org.zyxi.domain.payment.BookPaymentFactory;
import org.zyxi.domain.payment.repository.BookPaymentRepository;

@Component
@AllArgsConstructor
public class BuyBookCommandHandler implements Command.Handler<BuyBookCommand, Voidy> {

    private final BookRepository bookRepository;
    private final CurrentUserProviderService userProviderService;
    private final BookPaymentRepository bookPaymentRepository;

    @Override
    public Voidy handle(BuyBookCommand command) {
        BookId bookId = new BookId(command.bookId());
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("book doesn't exists");
        }
        UserId buyerId = userProviderService.get().getUserId();
        BookPaymentAggregate bookPayment = BookPaymentFactory.create(bookId, buyerId, command.receiptUrl());
        bookPaymentRepository.save(bookPayment);
        return null;
    }

}
