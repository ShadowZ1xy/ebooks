package org.domain.book;

import org.domain.book.value_objects.*;
import org.domain.user.UserAggregate;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;
import org.zyxi.book.value_objects.*;
import org.domain.common.Aggregate;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static org.domain.book.BookAggregate.BookId;

public class BookAggregate extends Aggregate<BookAggregate, BookId> {

    private Title title;
    private Author author;
    private Set<Genre> genre;
    private Text description;
    private ISBN isbn;
    private URL image;
    private LocalDate publishedAt;
    private Publisher publisher;
    private Association<UserAggregate, UserAggregate.UserId> createdBy;

    BookAggregate(Title title,
                  String authorName,
                  Set<Genre> genre,
                  Text description,
                  ISBN isbn,
                  URL image,
                  LocalDate publishedAt,
                  String publisherName,
                  Association<UserAggregate, UserAggregate.UserId> createdBy) {
        super(new BookId(UUID.randomUUID()));

        this.title = Objects.requireNonNull(title, "Title must not be null");
        this.author = new Author(new Name(Objects.requireNonNull(authorName, "Author name must not be null")));
        if (authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name must not be empty");
        }
        this.genre = Objects.requireNonNull(genre, "Genre must not be null");
        if (genre.isEmpty()) {
            throw new IllegalArgumentException("Genre set must not be empty");
        }
        this.description = Objects.requireNonNull(description, "Description must not be null");
        this.isbn = Objects.requireNonNull(isbn, "ISBN must not be null");
        this.image = Objects.requireNonNull(image, "Image URL must not be null");
        this.publishedAt = Objects.requireNonNull(publishedAt, "Published date must not be null");
        this.publisher = new Publisher(new Name(Objects.requireNonNull(publisherName, "Publisher name must not be null")));
        if (publisherName.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher name must not be empty");
        }
        this.createdBy = Objects.requireNonNull(createdBy, "Created by association must not be null");
    }

    public void changeTitle(Title title) {
        Objects.requireNonNull(title, "title is required");
        this.title = title;
    }

    BookAggregate(Long id,
                  LocalDateTime creationDateTime,
                  LocalDateTime lastUpdateDateTime,
                  BookId resourceId,
                  Title title,
                  Author author,
                  Set<Genre> genre,
                  Text description,
                  ISBN isbn,
                  URL image,
                  LocalDate publishedAt,
                  Publisher publisher,
                  Association<UserAggregate, UserAggregate.UserId> createdBy) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.isbn = isbn;
        this.image = image;
        this.publishedAt = publishedAt;
        this.publisher = publisher;
        this.createdBy = createdBy;
    }

    public record BookId(UUID resourceId) implements Identifier {

    }

}
