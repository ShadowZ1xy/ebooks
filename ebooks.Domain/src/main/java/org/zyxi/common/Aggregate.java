package org.zyxi.common;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;

import java.time.LocalDateTime;

public class Aggregate<T extends AggregateRoot<T, ID>, ID extends Identifier> implements AggregateRoot<T, ID>, Entity<T, ID> {

    private ID resourceId;
    private Long id;
    private LocalDateTime creationDateTime;
    private LocalDateTime lastUpdateDateTime;

    public Aggregate(ID resourceId) {
        this.resourceId = resourceId;
        creationDateTime = LocalDateTime.now();
        lastUpdateDateTime = LocalDateTime.now();
    }

    public Aggregate(Long id, ID resourceId, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
        this.id = id;
        this.resourceId = resourceId;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    @Override
    public ID getId() {
        return resourceId;
    }

    public Long getInnerId() {
        return id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public LocalDateTime getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }
}
