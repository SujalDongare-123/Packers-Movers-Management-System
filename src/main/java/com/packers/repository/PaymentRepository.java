package com.packers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packers.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Search payment by status
    List<Payment> findByPaymentStatusIgnoreCase(String paymentStatus);

}