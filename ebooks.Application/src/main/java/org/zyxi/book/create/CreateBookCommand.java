package org.zyxi.book.create;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.net.URL;
import java.time.LocalDate;

public record CreateBookCommand(
        String title,
        String author,
        String genre,
        String description,
        Integer isbn,
        URL image,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate published,
        String publisher
) implements Command<Voidy> {
}
