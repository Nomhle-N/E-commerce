/* PaymentController.java
   Ngwana Tiyani (231266731)
   Date: 21 June 2026
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

    @PostMapping("/process-card")
    public ResponseEntity<Payment> processCardPayment(
            @RequestParam String targetOrderId,
            @RequestParam double totalCapturedAmount,
            @RequestParam String paymentGatewayReference,
            @RequestParam String cardBrandType,
            @RequestBody BillingLocation billingAddress) {

        CardPayment cardPayment = PaymentFactory.createCardPayment(
                targetOrderId, totalCapturedAmount, billingAddress, paymentGatewayReference, cardBrandType
        );

        if (cardPayment == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(paymentService.savePayment(cardPayment), HttpStatus.CREATED);
    }

    @PostMapping("/process-wallet")
    public ResponseEntity<Payment> processDigitalWalletPayment(
            @RequestParam String targetOrderId,
            @RequestParam double totalCapturedAmount,
            @RequestParam String paymentProviderName,
            @RequestParam String electronicTokenVerification,
            @RequestBody BillingLocation billingAddress) {

        DigitalWalletPayment walletPayment = PaymentFactory.createDigitalWalletPayment(
                targetOrderId, totalCapturedAmount, billingAddress, paymentProviderName, electronicTokenVerification
        );

        if (walletPayment == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(paymentService.savePayment(walletPayment), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        Payment payment = paymentService.getPaymentById(id);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        Payment updated = paymentService.updatePayment(payment);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable String id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}