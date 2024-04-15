package org.zyxi.application.payment.pipeline.confirm_payment;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import java.util.UUID;

public record ConfirmBookPaymentCommand(
        UUID bookPaymentId
) implements Command<Voidy> {

}
