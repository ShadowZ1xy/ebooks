package org.zyxi.api.book;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.zyxi.application.book.pipeline.create.CreateBookCommand;
import org.zyxi.application.book.pipeline.rename.RenameBookCommand;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final Pipeline pipeline;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Voidy> createBook(@RequestBody CreateBookCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/rename")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Voidy> renameBook(@RequestBody RenameBookCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

}
