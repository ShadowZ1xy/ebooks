package org.zyxi.domain.common.ids;


import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

public record BookPaymentId(UUID resourceId) implements Identifier {

}
