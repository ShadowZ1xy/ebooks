package org.zyxi.domain.book.repository;

import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.domain.common.repository.Repository;

public interface BookRepository extends Repository<BookAggregate, BookId> {

    boolean existsById(BookId bookId);

    BookAggregate retrieveById(BookId bookId);

}
