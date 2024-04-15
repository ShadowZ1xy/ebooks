package org.zyxi.infra.payment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.zyxi.domain.common.DomainEvent;
import org.zyxi.domain.payment.BookPaymentStatus;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Entity
@Table(name = "book_payments")
public class BookPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name = "last_update_date_time")
    private LocalDateTime lastUpdateDateTime;

    @Column(name = "resource_id")
    private UUID resourceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookPaymentStatus status;

    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "book_id")
    private UUID bookId;
    @Column(name = "receipt_url")
    private URL receiptUrl;

    @org.springframework.data.annotation.Transient
    private final transient List<DomainEvent> domainEvents = new ArrayList();

    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        this.domainEvents.clear();
    }

    @DomainEvents
    protected Collection<Object> domainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    public void registerEvents(Collection<DomainEvent> events) {
        this.domainEvents.addAll(events);
    }

    public BookPaymentEntity(Long id,
                             LocalDateTime creationDateTime,
                             LocalDateTime lastUpdateDateTime,
                             UUID resourceId,
                             BookPaymentStatus status,
                             UUID userId,
                             UUID bookId,
                             URL receiptUrl) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.resourceId = resourceId;
        this.status = status;
        this.userId = userId;
        this.bookId = bookId;
        this.receiptUrl = receiptUrl;
    }

    protected BookPaymentEntity() {
    }

}
