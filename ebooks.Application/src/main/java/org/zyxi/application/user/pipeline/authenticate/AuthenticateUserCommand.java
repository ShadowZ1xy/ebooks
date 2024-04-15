package org.zyxi.application.user.pipeline.authenticate;

import an.awesome.pipelinr.Command;

public record AuthenticateUserCommand(
        String username,
        String password
) implements Command<AuthenticateUserCommandResponse> {
}
