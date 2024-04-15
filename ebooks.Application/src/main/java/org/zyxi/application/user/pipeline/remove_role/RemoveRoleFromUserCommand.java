package org.zyxi.application.user.pipeline.remove_role;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import org.zyxi.domain.user.value_objects.Role;

import java.util.UUID;

public record RemoveRoleFromUserCommand(
        UUID userId,
        Role role
) implements Command<Voidy> {
}
