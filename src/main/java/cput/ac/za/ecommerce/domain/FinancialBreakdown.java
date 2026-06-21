package cput.ac.za.ecommerce.domain;
/*
 * FinancialBreakdown.java
 * Author: Sinethemba Nyimbinya (220085870)
 */
import jakarta.persistence.Embeddable;

@Embeddable
public class FinancialBreakdown {
        private double basketSubTotal;
        private double calculatedVatAmount;
        private double finalInvoiceTotal;

        protected FinancialBreakdown() {}

        private FinancialBreakdown(Builder builder) {
            this.basketSubTotal = builder.basketSubTotal;
            this.calculatedVatAmount = builder.calculatedVatAmount;
            this.finalInvoiceTotal = builder.finalInvoiceTotal;
        }

        public double getBasketSubTotal() {
            return basketSubTotal;
        }

        public double getCalculatedVatAmount() {
            return calculatedVatAmount;
        }

        public double getFinalInvoiceTotal() {
            return finalInvoiceTotal;
        }

        public static class Builder {

            private double basketSubTotal;
            private double calculatedVatAmount;
            private double finalInvoiceTotal;

            public Builder setBasketSubTotal(double basketSubTotal) {
                this.basketSubTotal = basketSubTotal;
                return this;
            }

            public Builder setCalculatedVatAmount(double calculatedVatAmount) {
                this.calculatedVatAmount = calculatedVatAmount;
                return this;
            }

            public Builder setFinalInvoiceTotal(double finalInvoiceTotal) {
                this.finalInvoiceTotal = finalInvoiceTotal;
                return this;
            }

            public FinancialBreakdown build() {
                return new FinancialBreakdown(this);
            }
        }
    }

