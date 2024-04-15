package org.zyxi.application.book.pipeline.create;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.jmolecules.ddd.types.Association;
import org.springframework.stereotype.Component;
import org.zyxi.application.common.service.CurrentUserProviderService;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.book.BookFactory;
import org.zyxi.domain.book.repository.BookRepository;
import org.zyxi.domain.book.value_objects.Genre;
import org.zyxi.domain.book.value_objects.ISBN;
import org.zyxi.domain.book.value_objects.Text;
import org.zyxi.domain.book.value_objects.Title;
import org.zyxi.domain.common.ids.UserId;

@Component
@AllArgsConstructor
public class CreateBookCommandHandler implements Command.Handler<CreateBookCommand, Voidy> {

    private final CurrentUserProviderService userProviderService;
    private final BookRepository repository;

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
        repository.save(book);
        return null;
    }

}
