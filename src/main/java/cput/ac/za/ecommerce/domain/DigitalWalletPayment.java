/*
   DigitalWalletPayment.java
   Ngwana Tiyani (231266731)
   Date: 20 June 2026
 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "digital_wallet_payment")
@DiscriminatorValue("DIGITAL_WALLET")
public class DigitalWalletPayment extends Payment {

    private String paymentProviderName;
    private String electronicTokenVerification;


    protected DigitalWalletPayment() {}

    public String getPaymentProviderName() {
        return paymentProviderName;
    }

    public String getElectronicTokenVerification() {
        return electronicTokenVerification;
    }

    @Override
    public String toString() {
        return "DigitalWalletPayment{" +
                super.toString() + // Pulls in transactionId, targetOrderId, amount, timestamp, address
                ", paymentProviderName='" + paymentProviderName + '\'' +
                ", electronicTokenVerification='" + electronicTokenVerification + '\'' +
                '}';
    }


    private DigitalWalletPayment(Builder builder) {
        super(builder);
        this.paymentProviderName = builder.paymentProviderName;
        this.electronicTokenVerification = builder.electronicTokenVerification;
    }


    public static class Builder extends Payment.Builder {

        private String paymentProviderName;
        private String electronicTokenVerification;

        public Builder paymentProviderName(String paymentProviderName) {
            this.paymentProviderName = paymentProviderName;
            return this;
        }

        public Builder electronicTokenVerification(String electronicTokenVerification) {
            this.electronicTokenVerification = electronicTokenVerification;
            return this;
        }

        @Override
        public DigitalWalletPayment build() {
            return new DigitalWalletPayment(this);
        }
    }
}