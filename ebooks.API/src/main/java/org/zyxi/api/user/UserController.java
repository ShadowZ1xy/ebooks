package org.zyxi.api.user;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyxi.user.CreateUserCommand;

@AllArgsConstructor
@RestController("/api/v1/user")
public class UserController {

    private final Pipeline pipeline;

    @PostMapping
    public ResponseEntity<Voidy> createUser(CreateUserCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

}
