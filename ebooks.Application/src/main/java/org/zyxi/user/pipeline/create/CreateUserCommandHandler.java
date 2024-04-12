package org.zyxi.user.pipeline.create;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.zyxi.user.value_objects.EmailAddress;
import org.zyxi.user.value_objects.Name;
import org.zyxi.user.value_objects.Username;
import org.zyxi.user.UserAggregate;
import org.zyxi.user.repository.UserRepository;
import org.zyxi.user_details.service.JWTUtils;
import org.zyxi.user_details.service.CurrentUserProviderService;

@Component
@AllArgsConstructor
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, CreateUserCommandResponse> {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUserProviderService currentUserProviderService;
    private final JWTUtils jwtUtils;

    @Override
    public CreateUserCommandResponse handle(CreateUserCommand command) {
        Username username = new Username(command.username());
        EmailAddress emailAddress = new EmailAddress(command.email());
        validateUniqueness(username, emailAddress);
        Name firstName = new Name(command.firstName());
        Name lastName = new Name(command.lastName());
        String encodedPassword = passwordEncoder.encode(command.password());
        UserAggregate user = new UserAggregate(
                username,
                encodedPassword,
                emailAddress,
                firstName,
                lastName
        );
        repository.save(user);
        UserDetails userDetails = currentUserProviderService.loadUserByUsername(user.getUsername().getValue());
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
