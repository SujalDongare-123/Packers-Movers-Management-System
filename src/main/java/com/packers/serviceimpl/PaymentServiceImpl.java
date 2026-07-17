package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.Payment;
import com.packers.repository.PaymentRepository;
import com.packers.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    // Make Payment
    @Override
    public Payment makePayment(Payment payment) {
        return repository.save(payment);
    }

    // Get All Payments
    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    // Get Payment By Id
    @Override
    public Payment getPaymentById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));
    }

    // Update Payment
    @Override
    public Payment updatePayment(Long id, Payment payment) {

        Payment existingPayment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));

        existingPayment.setUser(payment.getUser());
        existingPayment.setQuotation(payment.getQuotation());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentStatus(payment.getPaymentStatus());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setTransactionId(payment.getTransactionId());

        return repository.save(existingPayment);
    }

    // Delete Payment
    @Override
    public void deletePayment(Long id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));

        repository.delete(payment);
    }

    // Search Payment By Status
    @Override
    public List<Payment> getPaymentsByStatus(String paymentStatus) {
        return repository.findByPaymentStatusIgnoreCase(paymentStatus);
    }
}