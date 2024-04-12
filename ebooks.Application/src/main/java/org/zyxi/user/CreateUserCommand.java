package org.zyxi.user;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import org.springframework.security.access.prepost.PreAuthorize;

public record CreateUserCommand(
        String username,
        String password,
        String email,
        String firstName,
        String lastName
) implements Command<Voidy> {
}
