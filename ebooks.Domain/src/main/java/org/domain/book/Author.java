package org.domain.book;

import org.jmolecules.ddd.types.Identifier;
import org.domain.book.value_objects.Name;
import org.domain.common.Entity;

import java.util.UUID;

import static org.domain.book.Author.*;

public class Author extends Entity<BookAggregate, Author, AuthorId> {

    private final Name name;

    Author(Name name) {
        super(new AuthorId(UUID.randomUUID()));
        if (name == null) {
            throw new RuntimeException("name can't be null");
        }
        this.name = name;
    }

    public Name getName() {
        return name;
    }


    public record AuthorId(UUID resourceId) implements Identifier {

    }

}
