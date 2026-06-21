/*
   Payment.java
   Ngwana Tiyani (231266731)
   Date: 19 June 2026
 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_method_type")

public abstract class Payment {

    @Id
    protected String transactionId;
    protected String targetOrderId;
    protected double totalCapturedAmount;
    protected LocalDateTime executionTimestamp;

    @Embedded
    protected BillingLocation billingAddress;

    protected Payment(){}



    public String getTransactionId() {
        return transactionId;
    }

    public String getTargetOrderId() {
        return targetOrderId;
    }

    public double getTotalCapturedAmount() {
        return totalCapturedAmount;
    }

    public LocalDateTime getExecutionTimestamp() {
        return executionTimestamp;
    }

    public BillingLocation getBillingAddress() {
        return billingAddress;
    }


    @Override
    public String  toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", targetOrderId='" + targetOrderId + '\'' +
                ", totalCapturedAmount=" + totalCapturedAmount +
                ", executionTimestamp=" + executionTimestamp +
                ", billingAddress=" + billingAddress +
                '}';
    }
    protected Payment (Builder builder)
    {
        this.transactionId = builder.transactionId;
        this.targetOrderId = builder.targetOrderId;
        this.totalCapturedAmount = builder.totalCapturedAmount;
        this.executionTimestamp = builder.executionTimestamp;
        this.billingAddress = builder.billingAddress;


    }


    public static class Builder {
        protected String transactionId;
        protected String targetOrderId;
        protected double totalCapturedAmount;
        protected LocalDateTime executionTimestamp;
        protected BillingLocation billingAddress;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }



        public Builder targetOrderId(String targetOrderId) {
            this.targetOrderId = targetOrderId;
            return this ;
        }
        public Builder totalCapturedAmount(double totalCapturedAmount) {
            this.totalCapturedAmount = totalCapturedAmount;
            return this;

        }
        public Builder executionTimestamp(LocalDateTime executionTimestamp) {
            this.executionTimestamp = executionTimestamp;
            return this;
        }
        public Builder billingAddress(BillingLocation billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }
        public Payment build()
        {
            return null;
        }

    }
}
