/*
   PaymentFactory.java
   Ngwana Tiyani (231266731)
   Date: 21 June 2026
 */


package cput.ac.za.ecommerce.factory;

import cput.ac.za.ecommerce.domain.BillingLocation;
import cput.ac.za.ecommerce.domain.CardPayment;
import cput.ac.za.ecommerce.domain.DigitalWalletPayment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentFactory {

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static CardPayment createCardPayment(String targetOrderId, double totalCapturedAmount,
                                                BillingLocation billingAddress, String paymentGatewayReference,
                                                String cardBrandType) {
        if (isNullOrEmpty(targetOrderId) || totalCapturedAmount <= 0.0 || billingAddress == null
                || isNullOrEmpty(paymentGatewayReference) || isNullOrEmpty(cardBrandType)) {
            return null;
        }

        return (CardPayment) new CardPayment.Builder()
                .paymentGatewayReference(paymentGatewayReference)
                .cardBrandType(cardBrandType)
                .transactionId(UUID.randomUUID().toString())
                .targetOrderId(targetOrderId)
                .totalCapturedAmount(totalCapturedAmount)
                .executionTimestamp(LocalDateTime.now())
                .billingAddress(billingAddress)
                .build();


    }

    public static DigitalWalletPayment createDigitalWalletPayment(String targetOrderId, double totalCapturedAmount,
                                                                  BillingLocation billingAddress, String paymentProviderName,
                                                                  String electronicTokenVerification)
    {
        if (isNullOrEmpty(targetOrderId) || totalCapturedAmount <= 0.0 || billingAddress == null
                || isNullOrEmpty(paymentProviderName) || isNullOrEmpty(electronicTokenVerification)) {
            return null;
        }

        return (DigitalWalletPayment) new DigitalWalletPayment.Builder()
                .paymentProviderName(paymentProviderName)
                .electronicTokenVerification(electronicTokenVerification)
                .transactionId(UUID.randomUUID().toString())
                .targetOrderId(targetOrderId)
                .totalCapturedAmount(totalCapturedAmount)
                .executionTimestamp(LocalDateTime.now())
                .billingAddress(billingAddress)
                .build();
    }

}
