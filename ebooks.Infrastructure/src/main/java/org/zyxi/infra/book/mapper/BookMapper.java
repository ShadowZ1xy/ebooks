package org.zyxi.infra.book.mapper;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.book.BookFactory;
import org.zyxi.domain.book.BookOwner;
import org.zyxi.domain.book.value_objects.Genre;
import org.zyxi.domain.book.value_objects.ISBN;
import org.zyxi.domain.book.value_objects.Text;
import org.zyxi.domain.book.value_objects.Title;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.BookOwnerId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.infra.book.entity.*;

import java.util.stream.Collectors;

public class BookMapper {

    public static BookEntity map(BookAggregate book,
                                 GenreEntity genre,
                                 AuthorEntity author,
                                 PublisherEntity publisher) {
        return new BookEntity(
                book.getInnerId(),
                book.getCreationDateTime(),
                book.getLastUpdateDateTime(),
                book.getId().resourceId(),
                book.getCreatedBy().resourceId(),
                book.getTitle().value(),
                genre,
                book.getDescription().value(),
                book.getIsbn().value(),
                book.getImage(),
                book.getPublishedAt(),
                author,
                publisher,
                book.getOwners().stream()
                        .map(o -> new BookOwnerEntity(
                                o.getInnerId(),
                                o.getCreationDateTime(),
                                o.getLastUpdateDateTime(),
                                o.getId().resourceId(),
                                o.getUserId().resourceId(),
                                book.getId().resourceId()
                        ))
                        .collect(Collectors.toSet())
        );
    }

    public static BookAggregate map(BookEntity book) {
        return BookFactory.map(
                book.getId(),
                book.getCreationDateTime(),
                book.getLastUpdateDateTime(),
                new BookId(book.getResourceId()),
                new Title(book.getTitle()),
                book.getAuthor().getResourceId(),
                book.getAuthor().getName(),
                new Genre(book.getGenre().getName()),
                new Text(book.getDescription()),
                new ISBN(book.getIsbn()),
                book.getImage(),
                book.getPublishedAt(),
                book.getPublisher().getResourceId(),
                book.getPublisher().getName(),
                Association.forId(new UserId(book.getCreatorId())),
                book.getOwners().stream()
                        .map(o -> new BookOwner(o.getId(),
                                new BookOwnerId(o.getResourceId()),
                                o.getCreationDateTime(),
                                o.getLastUpdateDateTime(),
                                new UserId(o.getUserId())))
                        .collect(Collectors.toSet())
        );
    }

}
