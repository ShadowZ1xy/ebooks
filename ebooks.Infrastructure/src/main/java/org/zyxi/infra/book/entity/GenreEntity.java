package org.zyxi.infra.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    private String name;

    public GenreEntity(String name) {
        this.name = name;
    }

    protected GenreEntity() {
    }

}
