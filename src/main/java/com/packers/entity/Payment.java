package com.packers.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    // Customer who made payment
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Payment for quotation
    @ManyToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    private Double amount;

    // UPI / CARD / NET_BANKING / CASH
    private String paymentMethod;

    // SUCCESS / FAILED / PENDING
    private String paymentStatus;

    private LocalDate paymentDate;

    private String transactionId;
}