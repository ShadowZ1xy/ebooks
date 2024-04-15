package org.zyxi.domain.common.ids;


import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

public record BookOwnerId(UUID resourceId) implements Identifier {

}
