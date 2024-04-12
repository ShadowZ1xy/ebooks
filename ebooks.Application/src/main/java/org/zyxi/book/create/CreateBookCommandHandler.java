package org.zyxi.book.create;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateBookCommandHandler implements Command.Handler<CreateBookCommand, Voidy> {

    @Override
    public Voidy handle(CreateBookCommand createBookCommand) {
        return null;
    }

}
