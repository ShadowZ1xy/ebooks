package org.application.user.pipeline.create;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.domain.user.UserFactory;
import org.domain.user.value_objects.EmailAddress;
import org.domain.user.value_objects.Name;
import org.domain.user.value_objects.Username;
import org.domain.user.UserAggregate;
import org.domain.user.repository.UserRepository;
import org.application.user_details.service.JWTUtils;
import org.application.user_details.service.UserProviderService;

@Component
@AllArgsConstructor
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, CreateUserCommandResponse> {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserProviderService userProviderService;
    private final JWTUtils jwtUtils;

    @Override
    public CreateUserCommandResponse handle(CreateUserCommand command) {
        Username username = new Username(command.username());
        EmailAddress emailAddress = new EmailAddress(command.email());
        validateUniqueness(username, emailAddress);
        Name firstName = new Name(command.firstName());
        Name lastName = new Name(command.lastName());
        String encodedPassword = passwordEncoder.encode(command.password());
        UserAggregate user = UserFactory.create(
                username,
                encodedPassword,
                emailAddress,
                firstName,
                lastName
        );
        repository.save(user);
        UserDetails userDetails = userProviderService.loadUserByUsername(user.getUsername().getValue());
        String jwtToken = jwtUtils.generateToken(userDetails);
        return new CreateUserCommandResponse(jwtToken);
    }

    private void validateUniqueness(Username username, EmailAddress email) {
        if (repository.existsByUsername(username)) {
            throw new RuntimeException("duplicate username");
        }
        if (repository.existsByEmail(email)) {
            throw new RuntimeException("duplicate email");
        }
    }

}
