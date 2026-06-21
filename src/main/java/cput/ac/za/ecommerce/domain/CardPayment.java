/*
   CardPayment.java
   Ngwana Tiyani (231266731)
   Date: 20 June 2026
 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "card_payment")
@DiscriminatorValue("CREDIT_DEBIT_CARD")
public class CardPayment extends Payment {

    private String paymentGatewayReference;
    private String cardBrandType;


    protected CardPayment() {}

    public String getPaymentGatewayReference() {
        return paymentGatewayReference;
    }

    public String getCardBrandType() {
        return cardBrandType;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                super.toString() + // Pulls in transactionId, targetOrderId, amount, timestamp, address
                ", paymentGatewayReference='" + paymentGatewayReference + '\'' +
                ", cardBrandType='" + cardBrandType + '\'' +
                '}';
    }


    private CardPayment(Builder builder) {
        super(builder);
        this.paymentGatewayReference = builder.paymentGatewayReference;
        this.cardBrandType = builder.cardBrandType;
    }


    public static class Builder extends Payment.Builder {

        private String paymentGatewayReference;
        private String cardBrandType;

        public Builder paymentGatewayReference(String paymentGatewayReference) {
            this.paymentGatewayReference = paymentGatewayReference;
            return this;
        }

        public Builder cardBrandType(String cardBrandType) {
            this.cardBrandType = cardBrandType;
            return this;
        }

        @Override
        public CardPayment build() {
            return new CardPayment(this);
        }
    }
}