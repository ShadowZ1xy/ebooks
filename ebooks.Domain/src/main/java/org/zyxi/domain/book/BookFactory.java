package org.zyxi.domain.book;

import org.jmolecules.ddd.types.Association;
import org.zyxi.domain.book.value_objects.Genre;
import org.zyxi.domain.book.value_objects.ISBN;
import org.zyxi.domain.book.value_objects.Text;
import org.zyxi.domain.book.value_objects.Title;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class BookFactory {

    public static BookAggregate create(Title title,
                                       String authorName,
                                       Genre genre,
                                       Text description,
                                       ISBN isbn,
                                       URL image,
                                       LocalDate publishedAt,
                                       String publisherName,
                                       Association<UserAggregate, UserId> createdBy) {
        return new BookAggregate(title,
                authorName,
                genre,
                description,
                isbn,
                image,
                publishedAt,
                publisherName,
                createdBy);
    }

    public static BookAggregate map(Long id,
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
        return new BookAggregate(id,
                creationDateTime,
                lastUpdateDateTime,
                bookId,
                title,
                authorId,
                authorName,
                genre,
                description,
                isbn,
                image,
                publishedAt,
                publisherId,
                publisherName,
                createdBy,
                owners);
    }

}
