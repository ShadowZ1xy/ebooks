package org.zyxi.domain.book;

import org.zyxi.domain.common.Entity;
import org.zyxi.domain.common.ids.BookOwnerId;
import org.zyxi.domain.common.ids.UserId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class BookOwner extends Entity<BookAggregate, BookOwner, BookOwnerId> {

    private final UserId userId;

    BookOwner(UserId userId) {
        super(new BookOwnerId(UUID.randomUUID()));
        this.userId = Objects.requireNonNull(userId, "ownerId can't be null");
    }

    public UserId getUserId() {
        return userId;
    }

    public BookOwner(Long id,
                     BookOwnerId resourceId,
                     LocalDateTime creationDateTime,
                     LocalDateTime lastUpdateDateTime,
                     UserId userId) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOwner bookOwner = (BookOwner) o;
        return userId.equals(bookOwner.userId) && getId().equals(bookOwner.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, getId());
    }

}
