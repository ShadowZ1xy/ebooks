package org.zyxi.infra.book.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "last_update_date_time")
    private LocalDateTime lastUpdateDateTime;
    @Column(name = "resource_id")
    private UUID resourceId;
    @Column(name = "name")
    private String name;

    public AuthorEntity(String name) {
        this.name = name;
        this.creationDateTime = LocalDateTime.now();
        this.lastUpdateDateTime = LocalDateTime.now();
        this.resourceId = UUID.randomUUID();
    }

    protected AuthorEntity() {
    }

}
