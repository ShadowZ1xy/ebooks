package org.zyxi.user.pipeline.remove_role;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.UserId;
import org.zyxi.user.repository.UserRepository;

@Component
@AllArgsConstructor
public class RemoveRoleFromUserCommandHandler implements Command.Handler<RemoveRoleFromUserCommand, Voidy> {

    private final UserRepository repository;

    @Override
    public Voidy handle(RemoveRoleFromUserCommand command) {
        UserId userId = new UserId(command.userId());
        UserAggregate user = repository.retrieve(userId);
        user.removeRole(command.role());
        repository.save(user);
        return null;
    }

}
