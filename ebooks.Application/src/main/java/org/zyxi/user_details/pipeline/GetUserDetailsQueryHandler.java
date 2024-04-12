package org.zyxi.user_details.pipeline;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.zyxi.user.repository.UserRepository;

@Component
@AllArgsConstructor
public class GetUserDetailsQueryHandler implements Command.Handler<GetUserDetailsQuery, UserDetails> {

    private final UserRepository repository;

    @Override
    public UserDetails handle(GetUserDetailsQuery command) {
        
    }
}
