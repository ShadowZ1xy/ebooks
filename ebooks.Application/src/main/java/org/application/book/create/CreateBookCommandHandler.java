package org.application.book.create;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.jmolecules.ddd.types.Association;
import org.springframework.stereotype.Component;
import org.domain.book.BookAggregate;
import org.domain.book.BookFactory;
import org.domain.book.value_objects.Genre;
import org.domain.book.value_objects.ISBN;
import org.domain.book.value_objects.Text;
import org.domain.book.value_objects.Title;
import org.application.common.service.CurrentUserProviderService;

import static org.domain.user.UserAggregate.*;

@Component
@AllArgsConstructor
public class CreateBookCommandHandler implements Command.Handler<CreateBookCommand, Voidy> {

    private final CurrentUserProviderService userProviderService;

    @Override
    public Voidy handle(CreateBookCommand command) {
        UserId creatorId = userProviderService.get().getUserId();
        Title title = new Title(command.title());
        Genre genre = new Genre(command.genre());
        Text description = new Text(command.description());
        ISBN isbn = new ISBN(command.isbn());

        BookAggregate book = BookFactory.create(
                title,
                command.author(),
                genre,
                description,
                isbn,
                command.image(),
                command.published(),
                command.publisher(),
                Association.forId(creatorId)
        );

    }

}
