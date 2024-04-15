package org.zyxi.application.book.pipeline.rename;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import java.util.UUID;

public record RenameBookCommand(
        UUID bookId,
        String title
) implements Command<Voidy> {

}
