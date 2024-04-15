package org.zyxi.application.payment.pipeline.decline_payment;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.payment.BookPaymentAggregate;
import org.zyxi.domain.payment.repository.BookPaymentRepository;

@Component
@AllArgsConstructor
public class DeclineBookPaymentCommandHandler implements Command.Handler<DeclineBookPaymentCommand, Voidy> {

    private final BookPaymentRepository bookPaymentRepository;

    @Override
    public Voidy handle(DeclineBookPaymentCommand command) {
        BookPaymentId bookPaymentId = new BookPaymentId(command.bookPaymentId());
        BookPaymentAggregate bookPayment = bookPaymentRepository.retrieve(bookPaymentId);
        bookPayment.decline();
        bookPaymentRepository.save(bookPayment);
        return null;
    }

}
