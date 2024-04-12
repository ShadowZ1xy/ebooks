package org.zyxi.user;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

public record UserId(UUID resourceId) implements ValueObject, Identifier {
}
