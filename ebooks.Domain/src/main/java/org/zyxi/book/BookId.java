package org.zyxi.book;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

public record BookId(UUID resourceId) implements ValueObject, Identifier {
}
