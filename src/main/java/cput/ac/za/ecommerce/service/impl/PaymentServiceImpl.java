/*
   PaymentServiceImpl
   Ngwana Tiyani (231266731)
   Date: 19 June 2026
 */


package cput.ac.za.ecommerce.service.impl;

import cput.ac.za.ecommerce.domain.Payment;
import cput.ac.za.ecommerce.repository.PaymentRepository;
import cput.ac.za.ecommerce.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {


    private final PaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        if (payment == null) {
            throw new NullPointerException("payment is null");
        }
        return repository.save(payment);
    }

    @Override
    public Payment getPaymentById(String paymentId) {
        return repository.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {
        if (payment == null || !repository.existsById(payment.getTransactionId())) {
            throw new IllegalArgumentException("Payment does not exist or is null");
        }
        return repository.save(payment);

    }

    @Override
    public void deletePayment(String paymentId) {
        if (repository.existsById(paymentId)) {
            repository.deleteById(paymentId);
        }

    }
}
