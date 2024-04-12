package org.zyxi.common;

import com.sun.jdi.event.ThreadStartEvent;
import org.apache.commons.lang3.NotImplementedException;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;

import java.time.LocalDateTime;

public class Aggregate<T extends AggregateRoot<T, ID>, ID extends Identifier> implements AggregateRoot<T, ID>, Entity<T, ID> {
    
    private Long id;
    private LocalDateTime creationDateTime;
    private LocalDateTime lastUpdateDateTime;

    public Aggregate() {
        creationDateTime = LocalDateTime.now();
        lastUpdateDateTime = LocalDateTime.now();
    }

    public Aggregate(Long id, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    @Override
    public ID getId() {
        throw new NotImplementedException();
    }
}
