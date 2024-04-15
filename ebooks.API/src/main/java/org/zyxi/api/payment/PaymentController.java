package org.zyxi.api.payment;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.zyxi.application.payment.pipeline.buy_book.BuyBookCommand;
import org.zyxi.application.payment.pipeline.confirm_payment.ConfirmBookPaymentCommand;
import org.zyxi.application.payment.pipeline.decline_payment.DeclineBookPaymentCommand;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final Pipeline pipeline;

    @PostMapping("/buy")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Voidy> buyBook(@RequestBody BuyBookCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/confirm")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Voidy> confirmBookPayment(@RequestBody ConfirmBookPaymentCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/decline")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Voidy> declineBookPayment(@RequestBody DeclineBookPaymentCommand command) {
        pipeline.send(command);
        return ResponseEntity.ok().build();
    }

}
