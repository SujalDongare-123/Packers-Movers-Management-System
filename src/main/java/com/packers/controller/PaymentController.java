package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.Payment;
import com.packers.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    // Make Payment
    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {

        return new ResponseEntity<>(service.makePayment(payment), HttpStatus.CREATED);
    }

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {

        return ResponseEntity.ok(service.getAllPayments());
    }

    // Get Payment By Id
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getPaymentById(id));
    }

    // Update Payment
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id,
                                                 @RequestBody Payment payment) {

        return ResponseEntity.ok(service.updatePayment(id, payment));
    }

    // Delete Payment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {

        service.deletePayment(id);

        return ResponseEntity.ok("Payment Deleted Successfully");
    }

    // Search Payment By Status
    @GetMapping("/status")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(
            @RequestParam String paymentStatus) {

        return ResponseEntity.ok(service.getPaymentsByStatus(paymentStatus));
    }

}