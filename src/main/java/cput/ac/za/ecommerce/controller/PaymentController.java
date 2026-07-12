/*
 * PaymentController.java
 * Ngwana Tiyani (231266731)
 * Date: 21 June 2026
 *
 * Controller responsible for handling payment-related HTTP requests.
 */

package cput.ac.za.ecommerce.controller;

import cput.ac.za.ecommerce.domain.BillingLocation;
import cput.ac.za.ecommerce.domain.CardPayment;
import cput.ac.za.ecommerce.domain.DigitalWalletPayment;
import cput.ac.za.ecommerce.domain.Payment;
import cput.ac.za.ecommerce.factory.PaymentFactory;
import cput.ac.za.ecommerce.service.IPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final IPaymentService paymentService;


    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/card")
    public ResponseEntity<Payment> processCardPayment(
            @RequestParam String targetOrderId,
            @RequestParam double totalCapturedAmount,
            @RequestParam String paymentGatewayReference,
            @RequestParam String cardBrandType,
            @RequestBody BillingLocation billingAddress) {

        if (isNullOrBlank(targetOrderId)
                || totalCapturedAmount <= 0
                || isNullOrBlank(paymentGatewayReference)
                || isNullOrBlank(cardBrandType)
                || billingAddress == null) {

            return ResponseEntity.badRequest().build();
        }

        CardPayment cardPayment =
                PaymentFactory.createCardPayment(
                        targetOrderId,
                        totalCapturedAmount,
                        billingAddress,
                        paymentGatewayReference,
                        cardBrandType
                );

        if (cardPayment == null) {
            return ResponseEntity.badRequest().build();
        }

        Payment savedPayment =
                paymentService.savePayment(cardPayment);

        if (savedPayment == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPayment);
    }

    @PostMapping("/wallet")
    public ResponseEntity<Payment> processDigitalWalletPayment(
            @RequestParam String targetOrderId,
            @RequestParam double totalCapturedAmount,
            @RequestParam String paymentProviderName,
            @RequestParam String electronicTokenVerification,
            @RequestBody BillingLocation billingAddress) {

        if (isNullOrBlank(targetOrderId)
                || totalCapturedAmount <= 0
                || isNullOrBlank(paymentProviderName)
                || isNullOrBlank(electronicTokenVerification)
                || billingAddress == null) {

            return ResponseEntity.badRequest().build();
        }

        DigitalWalletPayment walletPayment =
                PaymentFactory.createDigitalWalletPayment(
                        targetOrderId,
                        totalCapturedAmount,
                        billingAddress,
                        paymentProviderName,
                        electronicTokenVerification
                );

        if (walletPayment == null) {
            return ResponseEntity.badRequest().build();
        }

        Payment savedPayment =
                paymentService.savePayment(walletPayment);

        if (savedPayment == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(
            @PathVariable("id") String id) {

        if (isNullOrBlank(id)) {
            return ResponseEntity.badRequest().build();
        }

        Payment payment =
                paymentService.getPaymentById(id);

        if (payment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {

        List<Payment> payments =
                paymentService.getAllPayments();

        return ResponseEntity.ok(payments);
    }

    @PutMapping("/card/{id}")
    public ResponseEntity<Payment> updateCardPayment(
            @PathVariable("id") String id,
            @RequestBody CardPayment payment) {

        return updateExistingPayment(id, payment);
    }

    @PutMapping("/wallet/{id}")
    public ResponseEntity<Payment> updateWalletPayment(
            @PathVariable("id") String id,
            @RequestBody DigitalWalletPayment payment) {

        return updateExistingPayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(
            @PathVariable("id") String id) {

        if (isNullOrBlank(id)) {
            return ResponseEntity.badRequest().build();
        }

        Payment existingPayment =
                paymentService.getPaymentById(id);

        if (existingPayment == null) {
            return ResponseEntity.notFound().build();
        }

        paymentService.deletePayment(id);

        return ResponseEntity.noContent().build();
    }


    private ResponseEntity<Payment> updateExistingPayment(
            String id,
            Payment payment) {

        if (isNullOrBlank(id)
                || payment == null
                || isNullOrBlank(payment.getTransactionId())) {

            return ResponseEntity.badRequest().build();
        }


        if (!id.equals(payment.getTransactionId())) {
            return ResponseEntity.badRequest().build();
        }

        Payment updatedPayment =
                paymentService.updatePayment(payment);

        if (updatedPayment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedPayment);
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}