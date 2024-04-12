package org.zyxi.book;

import org.zyxi.book.value_objects.Title;
import org.zyxi.common.Aggregate;

import java.net.URL;
import java.time.LocalDate;

public class BookAggregate extends Aggregate<BookAggregate, BookId> {
    Title title,
    String author,
    String genre,
    String description,
    Integer isbn,
    URL image,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate published,
    String publisher
}
