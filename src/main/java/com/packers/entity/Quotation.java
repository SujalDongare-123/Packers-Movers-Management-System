package com.packers.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "quotations")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quotationId;

    // Customer who requested quotation
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Requested moving service
    @ManyToOne
    @JoinColumn(name = "service_id")
    private MovingService movingService;

    private String fromAddress;

    private String toAddress;

    private LocalDate shiftingDate;

    private String reference;

    @Column(length = 1000)
    private String serviceDetails;

    private String status;
}