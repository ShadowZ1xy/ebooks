package org.zyxi.domain.common;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Aggregate<T extends AggregateRoot<T, ID>, ID extends Identifier> extends Resource<ID> implements AggregateRoot<T, ID> {

    private final List<DomainEvent> domainEvents = new ArrayList();

    protected DomainEvent registerEvent(DomainEvent event) {
        Assert.notNull(event, "Domain event must not be null");
        this.domainEvents.add(event);
        return event;
    }

    public Collection<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    public Aggregate(ID resourceId) {
        super(resourceId);
    }

    public Aggregate(Long id, ID resourceId, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
        super(id, resourceId, creationDateTime, lastUpdateDateTime);
    }

}
