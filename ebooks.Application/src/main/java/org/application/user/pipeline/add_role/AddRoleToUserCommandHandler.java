package org.application.user.pipeline.add_role;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.domain.user.UserAggregate;
import org.domain.user.repository.UserRepository;

import static org.domain.user.UserAggregate.*;

@Component
@AllArgsConstructor
public class AddRoleToUserCommandHandler implements Command.Handler<AddRoleToUserCommand, Voidy> {

    private final UserRepository repository;

    @Override
    public Voidy handle(AddRoleToUserCommand command) {
        UserId userId = new UserId(command.userId());
        UserAggregate user = repository.retrieve(userId);
        user.addRole(command.role());
        repository.save(user);
        return null;
    }

}
