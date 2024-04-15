package org.zyxi.infra.book.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.zyxi.domain.book.BookAggregate;
import org.zyxi.domain.book.repository.BookRepository;
import org.zyxi.domain.book.value_objects.Name;
import org.zyxi.domain.common.ids.BookId;
import org.zyxi.infra.book.entity.AuthorEntity;
import org.zyxi.infra.book.entity.BookEntity;
import org.zyxi.infra.book.entity.GenreEntity;
import org.zyxi.infra.book.entity.PublisherEntity;
import org.zyxi.infra.book.mapper.BookMapper;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookRepository;
    private final AuthorJpaRepository authorRepository;
    private final PublisherJpaRepository publisherRepository;

    @Override
    public void save(BookAggregate book) {
        AuthorEntity author = findOrCreateAuthor(book.getAuthor().getName());
        PublisherEntity publisher = findOrCreatePublisher(book.getPublisher().getName());
        BookEntity bookEntity = BookMapper.map(
                book,
                new GenreEntity(book.getGenre().value()),
                author,
                publisher
        );
        bookRepository.save(bookEntity);
    }

    @Override
    public boolean existsById(BookId bookId) {
        return bookRepository.existsByResourceId(bookId.resourceId());
    }

    @Override
    public BookAggregate retrieveById(BookId bookId) {
        BookEntity bookEntity = bookRepository.findByResourceId(bookId.resourceId());
        if (bookEntity == null) {
            throw new RuntimeException("book doesn't exists");
        }
        return BookMapper.map(bookEntity);
    }

    private AuthorEntity findOrCreateAuthor(Name name) {
        String authorName = name.getValue();
        AuthorEntity author = authorRepository.findByName(authorName);
        if (author == null) {
            author = authorRepository.save(new AuthorEntity(authorName));
        }
        return author;
    }

    private PublisherEntity findOrCreatePublisher(Name name) {
        String publisher = name.getValue();
        PublisherEntity author = publisherRepository.findByName(publisher);
        if (author == null) {
            author = publisherRepository.save(new PublisherEntity(publisher));
        }
        return author;
    }

}
