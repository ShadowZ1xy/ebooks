package org.zyxi.user_details.pipeline;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.user_details.model.CurrentUser;
import org.zyxi.user_details.repository.UserDetailsRepository;

@Component
@AllArgsConstructor
public class GetUserDetailsQueryHandler implements Command.Handler<GetUserDetailsQuery, CurrentUser> {

    private final UserDetailsRepository repository;

    @Override
    public CurrentUser handle(GetUserDetailsQuery command) {
        return repository.findByUsername(command.username());
    }
}
