package org.zyxi.api.book;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.application.book.create.CreateBookCommand;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final Pipeline pipeline;

    @PostMapping("/create")
    public ResponseEntity<Voidy> signUp(@RequestBody CreateBookCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }
}
