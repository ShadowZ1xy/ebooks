package org.zyxi.domain.book;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.book.value_objects.*;
import org.zyxi.domain.common.Aggregate;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class BookAggregate extends Aggregate<BookAggregate, BookId> {

    private Title title;
    private Author author;
    private Genre genre;
    private Text description;
    private ISBN isbn;
    private URL image;
    private LocalDate publishedAt;
    private Publisher publisher;
    private Association<UserAggregate, UserId> createdBy;
    private Set<BookOwner> owners;

    BookAggregate(Title title,
                  String authorName,
                  Genre genre,
                  Text description,
                  ISBN isbn,
                  URL image,
                  LocalDate publishedAt,
                  String publisherName,
                  Association<UserAggregate, UserId> createdBy) {
        super(new BookId(UUID.randomUUID()));

        this.title = Objects.requireNonNull(title, "Title must not be null");
        this.author = new Author(new Name(Objects.requireNonNull(authorName, "Author name must not be null")));
        if (authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name must not be empty");
        }
        this.genre = Objects.requireNonNull(genre, "Genre must not be null");
        this.description = Objects.requireNonNull(description, "Description must not be null");
        this.isbn = Objects.requireNonNull(isbn, "ISBN must not be null");
        this.image = Objects.requireNonNull(image, "Image URL must not be null");
        this.publishedAt = Objects.requireNonNull(publishedAt, "Published date must not be null");
        this.publisher = new Publisher(new Name(Objects.requireNonNull(publisherName, "Publisher name must not be null")));
        if (publisherName.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher name must not be empty");
        }
        this.createdBy = Objects.requireNonNull(createdBy, "Created by association must not be null");
        this.owners = new HashSet<>();
    }

    public void changeTitle(Title title) {
        Objects.requireNonNull(title, "title is required");
        this.title = title;
    }

    public void addOwner(UserId userId) {
        this.owners.add(new BookOwner(userId));
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public Text getDescription() {
        return description;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public URL getImage() {
        return image;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public UserId getCreatedBy() {
        return createdBy.getId();
    }

    public Set<BookOwner> getOwners() {
        return Collections.unmodifiableSet(this.owners);
    }

    BookAggregate(Long id,
                  LocalDateTime creationDateTime,
                  LocalDateTime lastUpdateDateTime,
                  BookId bookId,
                  Title title,
                  UUID authorId,
                  String authorName,
                  Genre genre,
                  Text description,
                  ISBN isbn,
                  URL image,
                  LocalDate publishedAt,
                  UUID publisherId,
                  String publisherName,
                  Association<UserAggregate, UserId> createdBy,
                  Set<BookOwner> owners) {
        super(id, bookId, creationDateTime, lastUpdateDateTime);
        this.title = title;
        this.author = new Author(authorId, new Name(authorName));
        this.genre = genre;
        this.description = description;
        this.isbn = isbn;
        this.image = image;
        this.publishedAt = publishedAt;
        this.publisher = new Publisher(publisherId, new Name(publisherName));
        this.createdBy = createdBy;
        this.owners = owners;
    }

}
