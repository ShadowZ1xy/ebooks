package org.zyxi.api.user;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.application.user.pipeline.add_role.AddRoleToUserCommand;
import org.application.user.pipeline.authenticate.AuthenticateUserCommand;
import org.application.user.pipeline.authenticate.AuthenticateUserCommandResponse;
import org.application.user.pipeline.change_name.ChangeNameCommand;
import org.application.user.pipeline.create.CreateUserCommand;
import org.application.user.pipeline.create.CreateUserCommandResponse;
import org.application.user.pipeline.remove_role.RemoveRoleFromUserCommand;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final Pipeline pipeline;

    @PostMapping("/registration")
    public ResponseEntity<CreateUserCommandResponse> signUp(@RequestBody CreateUserCommand command) {
        CreateUserCommandResponse response = pipeline.send(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateUserCommandResponse> authenticate(@RequestBody AuthenticateUserCommand command) {
        AuthenticateUserCommandResponse response = pipeline.send(command);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/add-role")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Voidy> addRole(@RequestBody AddRoleToUserCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/remove-role")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Voidy> removeRole(@RequestBody RemoveRoleFromUserCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change-name")
    @PreAuthorize("hasRole('SUPER_ADMIN') OR @securityService.IsSelf(#command.userId())")
    public ResponseEntity<Voidy> changeName(@RequestBody ChangeNameCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

}
