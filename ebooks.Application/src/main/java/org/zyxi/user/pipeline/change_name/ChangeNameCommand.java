package org.zyxi.user.pipeline.change_name;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import java.util.UUID;

public record ChangeNameCommand(UUID userId, String name)
        implements Command<Voidy> {
}
