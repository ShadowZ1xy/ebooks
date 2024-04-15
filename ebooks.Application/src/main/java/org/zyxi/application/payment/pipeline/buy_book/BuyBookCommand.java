package org.zyxi.application.payment.pipeline.buy_book;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import java.net.URL;
import java.util.UUID;

public record BuyBookCommand(
        UUID bookId,
        URL receiptUrl
) implements Command<Voidy> {

}
