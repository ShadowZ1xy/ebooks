package org.zyxi.application.payment.pipeline.confirm_payment;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.BookPaymentId;
import org.zyxi.domain.payment.BookPaymentAggregate;
import org.zyxi.domain.payment.repository.BookPaymentRepository;

@Component
@AllArgsConstructor
public class ConfirmBookPaymentCommandHandler implements Command.Handler<ConfirmBookPaymentCommand, Voidy> {

    private final BookPaymentRepository bookPaymentRepository;

    @Override
    public Voidy handle(ConfirmBookPaymentCommand command) {
        BookPaymentId bookPaymentId = new BookPaymentId(command.bookPaymentId());
        BookPaymentAggregate bookPayment = bookPaymentRepository.retrieve(bookPaymentId);
        bookPayment.confirm();
        bookPaymentRepository.save(bookPayment);
        return null;
    }

}
