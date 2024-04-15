package org.zyxi.domain.common.repository;

import org.jmolecules.ddd.types.Identifier;
import org.zyxi.domain.common.Aggregate;

public interface Repository<T extends Aggregate<T, ID>, ID extends Identifier>
        extends org.jmolecules.ddd.types.Repository<T, ID> {

    void save(T t);

}
