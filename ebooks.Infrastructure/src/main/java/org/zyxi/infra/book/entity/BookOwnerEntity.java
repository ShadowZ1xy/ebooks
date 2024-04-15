package org.zyxi.infra.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "book_owners")
public class BookOwnerEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "last_update_date_time")
    private LocalDateTime lastUpdateDateTime;
    @Column(name = "resource_id")
    private UUID resourceId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "book_id")
    private UUID bookId;

    public BookOwnerEntity(Long id,
                           LocalDateTime creationDateTime,
                           LocalDateTime lastUpdateDateTime,
                           UUID resourceId,
                           UUID userId,
                           UUID bookId) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.resourceId = resourceId;
        this.userId = userId;
        this.bookId = bookId;
    }

    protected BookOwnerEntity() {
    }

}
