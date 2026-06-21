package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.BillingLocation;
import cput.ac.za.ecommerce.domain.CardPayment;
import cput.ac.za.ecommerce.domain.DigitalWalletPayment;
import cput.ac.za.ecommerce.factory.PaymentFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PaymentFactoryTest {

    private BillingLocation validAddress;

    @BeforeEach
    public void setup() {
        validAddress = new BillingLocation.Builder()
                .billingStreet("123 Main St")
                .billingCity("Cape Town")
                .billingPostalCode("8000")
                .build();
    }
    @Test
    void testCreateCardPaymentSuccess()
    {
        CardPayment cardPayment = PaymentFactory.createCardPayment(
                "ORD-2376",
                13789.00,
                validAddress,
                "PAYGATE-REF-356",
                "MasterCard"
        );

        assertNotNull(cardPayment);
        assertNotNull(cardPayment.getTransactionId());
        assertNotNull(cardPayment.getExecutionTimestamp());
        assertNotNull("ORD-2376",cardPayment.getTransactionId());
        assertNotNull("PAYGATE-REF-356",cardPayment.getCardBrandType());
    }

    @Test
    void testCreateCardPaymentFailsOnInvalidAmount() {

        // Business Rule Check: Payment amount cannot be zero or negative
        CardPayment cardPayment = PaymentFactory.createCardPayment(
                "ORD-99211",
                -50.00,
                validAddress,
                "PAYGATE-REF-883",
                "MasterCard"
        );

        assertNull(cardPayment);
    }
@Test
void testCreateDigitalWalletPaymentFailsOnMissingProvider()
{
    // Business Rule check: This check if Provider name is not blank or empty

    DigitalWalletPayment walletPayment = PaymentFactory.createDigitalWalletPayment(
            "ORD-100",
            570.00,
            validAddress,
            "",
            "TOKEN-SNAP-19P"
    );
    assertNull(walletPayment);

}

}
