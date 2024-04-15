package org.zyxi.application.payment.pipeline.decline_payment;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import java.util.UUID;

public record DeclineBookPaymentCommand(
        UUID bookPaymentId
) implements Command<Voidy> {

}
