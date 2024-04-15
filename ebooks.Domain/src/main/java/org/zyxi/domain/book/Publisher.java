package org.zyxi.domain.book;

import org.jmolecules.ddd.types.Identifier;
import org.zyxi.domain.book.value_objects.Name;
import org.zyxi.domain.common.Entity;

import java.util.UUID;

import static org.zyxi.domain.book.Publisher.PublisherId;

public class Publisher extends Entity<BookAggregate, Publisher, PublisherId> {

    private final Name name;

    Publisher(Name name) {
        super(new PublisherId(UUID.randomUUID()));
        if (name == null) {
            throw new RuntimeException("name can't be null");
        }
        this.name = name;
    }

    Publisher(UUID resourceId, Name name) {
        super(new PublisherId(resourceId));
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public record PublisherId(UUID resourceId) implements Identifier {

    }

}
