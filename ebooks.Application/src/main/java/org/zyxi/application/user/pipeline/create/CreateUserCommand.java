package org.zyxi.application.user.pipeline.create;

import an.awesome.pipelinr.Command;

public record CreateUserCommand(
        String username,
        String password,
        String email,
        String firstName,
        String lastName
) implements Command<CreateUserCommandResponse> {
}
