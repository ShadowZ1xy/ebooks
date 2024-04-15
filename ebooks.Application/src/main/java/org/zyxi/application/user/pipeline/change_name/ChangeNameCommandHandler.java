package org.zyxi.application.user.pipeline.change_name;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zyxi.domain.common.ids.UserId;
import org.zyxi.domain.user.UserAggregate;
import org.zyxi.domain.user.repository.UserRepository;
import org.zyxi.domain.user.value_objects.Name;

@Component
@AllArgsConstructor
public class ChangeNameCommandHandler implements Command.Handler<ChangeNameCommand, Voidy> {

    private final UserRepository repository;

    @Override
    public Voidy handle(ChangeNameCommand command) {
        UserAggregate user = repository.retrieve(new UserId(command.userId()));
        user.changeName(new Name(command.name()));
        repository.save(user);
        return null;
    }

}
