package org.zyxi.user_details.pipeline;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.zyxi.user_details.repository.UserDetailsRepository;

@Component
@AllArgsConstructor
public class GetUserDetailsQueryHandler implements Command.Handler<GetUserDetailsQuery, UserDetails> {

    private final UserDetailsRepository repository;

    @Override
    public UserDetails handle(GetUserDetailsQuery command) {
        return repository.loadUserByUsername(command.username());
    }
}
