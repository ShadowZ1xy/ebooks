package org.domain.common;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import java.time.LocalDateTime;

public class Aggregate<T extends AggregateRoot<T, ID>, ID extends Identifier> extends Resource<ID> implements AggregateRoot<T, ID> {

    public Aggregate(ID resourceId) {
        super(resourceId);
    }

    public Aggregate(Long id, ID resourceId, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
    }

}
