package org.application.user.pipeline.authenticate;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.application.user_details.service.JWTUtils;
import org.application.user_details.service.UserProviderService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticateUserCommandHandler implements Command.Handler<AuthenticateUserCommand, AuthenticateUserCommandResponse> {

    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserProviderService userProviderService;

    @Override
    public AuthenticateUserCommandResponse handle(AuthenticateUserCommand command) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(command.username(), command.password()));
        UserDetails userDetails = userProviderService.loadUserByUsername(command.username());
        String jwtToken = jwtUtils.generateToken(userDetails);
        return new AuthenticateUserCommandResponse(jwtToken);
    }

}
