package org.domain.common;

import org.jmolecules.ddd.types.Identifiable;
import org.jmolecules.ddd.types.Identifier;

import java.time.LocalDateTime;

public class Resource<ID extends Identifier> implements Identifiable<ID> {

    private ID resourceId;
    private Long id;
    private LocalDateTime creationDateTime;
    private LocalDateTime lastUpdateDateTime;

    public Resource(ID resourceId) {
        this.resourceId = resourceId;
        creationDateTime = LocalDateTime.now();
        lastUpdateDateTime = LocalDateTime.now();
    }

    public Resource(Long id, ID resourceId, LocalDateTime creationDateTime, LocalDateTime lastUpdateDateTime) {
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
