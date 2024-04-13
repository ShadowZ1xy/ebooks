package org.domain.common;

import org.jmolecules.ddd.types.Identifier;

import java.time.LocalDateTime;

public class Entity
        <T extends Aggregate<T, ?>, E, ID extends Identifier>
        extends Resource<ID>
        implements org.jmolecules.ddd.types.Entity<T, ID> {

    public Entity(ID resourceId) {
        super(resourceId);
    }

    public Entity(Long id, ID resourceId, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
    }

}
