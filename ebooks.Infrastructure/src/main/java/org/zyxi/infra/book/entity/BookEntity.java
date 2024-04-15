package org.zyxi.infra.book.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "last_update_date_time")
    private LocalDateTime lastUpdateDateTime;

    @Column(name = "creator_id")
    private UUID creatorId;

    @Column(name = "resource_id")
    private UUID resourceId;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genre")
    private GenreEntity genre;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "isbn", unique = true)
    private Integer isbn;

    @Column(name = "image_url")
    private URL image;

    @Column(name = "published_at")
    private LocalDate publishedAt;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @OneToMany(mappedBy = "bookId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookOwnerEntity> owners = new HashSet<>();

    protected BookEntity() {
    }

    public BookEntity(Long id,
                      LocalDateTime creationDateTime,
                      LocalDateTime lastUpdateDateTime,
                      UUID resourceId,
                      UUID creatorId,
                      String title,
                      GenreEntity genre,
                      String description,
                      Integer isbn,
                      URL image,
                      LocalDate publishedAt,
                      AuthorEntity author,
                      PublisherEntity publisher,
                      Set<BookOwnerEntity> owners) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.resourceId = resourceId;
        this.creatorId = creatorId;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.isbn = isbn;
        this.image = image;
        this.publishedAt = publishedAt;
        this.author = author;
        this.publisher = publisher;
        this.owners = owners;
    }

}
