package com.packers.service;

import java.util.List;

import com.packers.entity.Payment;

public interface PaymentService {

    Payment makePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    Payment updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

    List<Payment> getPaymentsByStatus(String paymentStatus);

}