package org.application.user_details.pipeline;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.infra.user_details.model.BaseUser;
import org.infra.user_details.repository.UserDetailsRepository;

@Component
@AllArgsConstructor
public class GetUserDetailsQueryHandler implements Command.Handler<GetUserDetailsQuery, BaseUser> {

    private final UserDetailsRepository repository;

    @Override
    public BaseUser handle(GetUserDetailsQuery command) {
        return repository.findByUsername(command.username());
    }
}
