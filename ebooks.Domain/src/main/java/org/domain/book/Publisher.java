package org.domain.book;

import org.jmolecules.ddd.types.Identifier;
import org.domain.book.value_objects.Name;
import org.domain.common.Entity;

import java.util.UUID;

import static org.domain.book.Publisher.PublisherId;

public class Publisher extends Entity<BookAggregate, Publisher, PublisherId> {

    private final Name name;

    Publisher(Name name) {
        super(new PublisherId(UUID.randomUUID()));
        if (name == null) {
            throw new RuntimeException("name can't be null");
        }
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public record PublisherId(UUID resourceId) implements Identifier {

    }

}
