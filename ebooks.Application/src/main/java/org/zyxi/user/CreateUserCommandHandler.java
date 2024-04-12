package org.zyxi.user;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.common.value_objects.EmailAddress;
import org.zyxi.common.value_objects.Name;
import org.zyxi.common.value_objects.Username;
import org.zyxi.user.repository.UserRepository;

@Component
@AllArgsConstructor
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, Voidy> {

    private final UserRepository repository;

    @Override
    public Voidy handle(CreateUserCommand command) {
        Username username = new Username(command.username());
        EmailAddress emailAddress = new EmailAddress(command.email());
        Name firstName = new Name(command.firstName());
        Name lastName = new Name(command.lastName());
        UserAggregate user = new UserAggregate(
                username,
                command.password(),
                emailAddress,
                firstName,
                lastName
        );
        repository.save(user);
        return null;
    }
}
