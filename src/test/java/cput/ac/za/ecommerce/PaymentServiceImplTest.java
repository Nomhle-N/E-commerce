// PaymentServiceImplTest.java
// Ngwana Tiyani 231266731
// 28 June 2026

package cput.ac.za.ecommerce;


import cput.ac.za.ecommerce.domain.BillingLocation;
import cput.ac.za.ecommerce.domain.CardPayment;
import cput.ac.za.ecommerce.domain.Payment;
import cput.ac.za.ecommerce.repository.PaymentRepository;
import cput.ac.za.ecommerce.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository repository; // Mocks the database operations layer

    @InjectMocks
    private PaymentServiceImpl service;   // Automatically injects the mocked repository into your service

    private CardPayment samplePayment;

    @BeforeEach
    void setUp() {
        BillingLocation address = new BillingLocation.Builder()
                .billingStreet("22 Keizersgracht Street")
                .billingCity("Cape Town")
                .billingPostalCode("8001")
                .build();

        samplePayment = (CardPayment) new CardPayment.Builder()
                .paymentGatewayReference("PAY-GATE-9921X")
                .cardBrandType("Visa")
                .transactionId("TXN-77321-UUID")
                .targetOrderId("ORD-88219")
                .totalCapturedAmount(1250.00)
                .executionTimestamp(LocalDateTime.now())
                .billingAddress(address)
                .build();
    }

    @Test
    void testSavePaymentSuccess() {

        when(repository.save(any(Payment.class))).thenReturn(samplePayment);

        Payment result = service.savePayment(samplePayment);

        assertNotNull(result);
        assertEquals("TXN-77321-UUID", result.getTransactionId());
        assertEquals(1250.00, result.getTotalCapturedAmount());
        verify(repository, times(1)).save(samplePayment);
    }

    @Test
    void testSavePaymentNullFails() {

        Payment result = service.savePayment(null);

        assertNull(result);
        verify(repository, never()).save(any(Payment.class));
    }

    @Test
    void testGetPaymentByIdSuccess() {

        when(repository.findById("TXN-77321-UUID")).thenReturn(Optional.of(samplePayment));


        Payment result = service.getPaymentById("TXN-77321-UUID");


        assertNotNull(result);
        assertEquals("ORD-88219", result.getTargetOrderId());
        verify(repository, times(1)).findById("TXN-77321-UUID");
    }

    @Test
    void testGetPaymentByIdNotFound() {

        when(repository.findById("INVALID-ID")).thenReturn(Optional.empty());


        Payment result = service.getPaymentById("INVALID-ID");


        assertNull(result);
        verify(repository, times(1)).findById("INVALID-ID");
    }

    @Test
    void testGetAllPayments() {

        when(repository.findAll()).thenReturn(List.of(samplePayment));


        List<Payment> results = service.getAllPayments();


        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("TXN-77321-UUID", results.get(0).getTransactionId());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testUpdatePaymentSuccess() {
        // Arrange
        when(repository.existsById("TXN-77321-UUID")).thenReturn(true);
        when(repository.save(any(Payment.class))).thenReturn(samplePayment);

        Payment result = service.updatePayment(samplePayment);

        assertNotNull(result);
        verify(repository, times(1)).existsById("TXN-77321-UUID");
        verify(repository, times(1)).save(samplePayment);
    }

    @Test
    void testUpdatePaymentFailsWhenRecordDoesNotExist() {

        when(repository.existsById("TXN-77321-UUID")).thenReturn(false);

        Payment result = service.updatePayment(samplePayment);


        assertNull(result);
        verify(repository, times(1)).existsById("TXN-77321-UUID");
        verify(repository, never()).save(any(Payment.class));
    }

    @Test
    void testDeletePaymentSuccess() {

        when(repository.existsById("TXN-77321-UUID")).thenReturn(true);
        doNothing().when(repository).deleteById("TXN-77321-UUID");

        service.deletePayment("TXN-77321-UUID");

        verify(repository, times(1)).existsById("TXN-77321-UUID");
        verify(repository, times(1)).deleteById("TXN-77321-UUID");
    }

    @Test
    void testDeletePaymentSkippedWhenIdNotFound() {

        when(repository.existsById("INVALID-ID")).thenReturn(false);

        service.deletePayment("INVALID-ID");

        verify(repository, times(1)).existsById("INVALID-ID");
        verify(repository, never()).deleteById(anyString());
    }
}
