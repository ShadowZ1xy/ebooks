package org.zyxi.domain.common.ids;


import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

public record UserId(UUID resourceId) implements Identifier {

}
