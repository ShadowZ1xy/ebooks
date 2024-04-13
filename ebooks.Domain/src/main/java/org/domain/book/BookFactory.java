package org.domain.book;

import org.domain.book.value_objects.Genre;
import org.domain.book.value_objects.ISBN;
import org.domain.book.value_objects.Text;
import org.domain.book.value_objects.Title;
import org.domain.user.UserAggregate;
import org.jmolecules.ddd.types.Association;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class BookFactory {

    public static BookAggregate create(Title title,
                                       String authorName,
                                       Genre genre,
                                       Text description,
                                       ISBN isbn,
                                       URL image,
                                       LocalDate publishedAt,
                                       String publisherName,
                                       Association<UserAggregate, UserAggregate.UserId> createdBy) {
        return new BookAggregate(title, authorName, Set.of(genre), description, isbn, image, publishedAt, publisherName, createdBy);
    }

    public static BookAggregate map(Long id,
                                    LocalDateTime creationDateTime,
                                    LocalDateTime lastUpdateDateTime,
                                    BookAggregate.BookId resourceId,
                                    Title title,
                                    Author author,
                                    Set<Genre> genre,
                                    Text description,
                                    ISBN isbn,
                                    URL image,
                                    LocalDate publishedAt,
                                    Publisher publisher,
                                    Association<UserAggregate, UserAggregate.UserId> createdBy) {
        return new BookAggregate(id, creationDateTime, lastUpdateDateTime, resourceId, title, author, genre, description, isbn, image, publishedAt, publisher, createdBy);
    }

}
