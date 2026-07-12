/*
   PaymentServiceImpl
   Ngwana Tiyani (231266731)
   Date: 07 July 2026
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


    private static PaymentServiceImpl service = null;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
        service = this;
    }


    public static PaymentServiceImpl getService() {
        return service;
    }

    @Override
    public Payment savePayment(Payment payment) {


        if (payment == null) {
            return null;
        }

        return repository.save(payment);
    }

    @Override
    public Payment getPaymentById(String paymentId) {

        //Prevents searching with null or blank IDs.

        if (isNullOrEmpty(paymentId)) {
            return null;
        }

        return repository.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {

        return repository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {

        if (payment == null || isNullOrEmpty(payment.getTransactionId())) {
            return null;
        }


        if (!repository.existsById(payment.getTransactionId())) {
            return null;
        }

        return repository.save(payment);
    }

    @Override
    public void deletePayment(String paymentId) {

        if (!isNullOrEmpty(paymentId) && repository.existsById(paymentId)) {
            repository.deleteById(paymentId);
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}

//End of program