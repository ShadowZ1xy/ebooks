package org.zyxi.application.book.pipeline.rename;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.jmolecules.ddd.types.Association;
import org.springframework.stereotype.Component;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.book.BookFactory;
import org.zyxi.domain.book.repository.BookRepository;
import org.zyxi.domain.book.value_objects.Genre;
import org.zyxi.domain.book.value_objects.ISBN;
import org.zyxi.domain.book.value_objects.Text;
import org.zyxi.domain.book.value_objects.Title;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.infra.book.entity.BookEntity;

@Component
@AllArgsConstructor
public class RenameBookCommandHandler implements Command.Handler<RenameBookCommand, Voidy> {

    private final BookRepository repository;

    @Override
    public Voidy handle(RenameBookCommand command) {
        BookAggregate book = repository.retrieveById(new BookId(command.bookId()));
        book.changeTitle(new Title(command.title()));
        repository.save(book);
        return null;
    }

}
