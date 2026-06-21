/*
   IPaymentService
   Ngwana Tiyani (231266731)
   Date: 19 June 2026
 */


package cput.ac.za.ecommerce.service;

import cput.ac.za.ecommerce.domain.Payment;

import java.util.List;

public interface IPaymentService {

    Payment savePayment(Payment payment);
    Payment getPaymentById(String paymentId);
    List<Payment> getAllPayments();
    Payment updatePayment(Payment payment);
    void deletePayment(String paymentId);
}
