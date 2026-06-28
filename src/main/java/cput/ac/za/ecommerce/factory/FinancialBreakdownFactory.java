 /*
  * FinancialBreakdownFactory.java
  * Author: Sinethemba Nyimbinya (220085870)
  * Date: 2026
  */
 package cput.ac.za.ecommerce.factory;
 import cput.ac.za.ecommerce.domain.FinancialBreakdown;

 public class FinancialBreakdownFactory {

     public static FinancialBreakdown createFinancialBreakdown(
                double basketSubTotal,
                double calculatedVatAmount,
                double finalInvoiceTotal) {

            if (basketSubTotal < 0)
                return null;

            if (calculatedVatAmount < 0)
                return null;

            if (finalInvoiceTotal < basketSubTotal)
                return null;

            return new FinancialBreakdown.Builder()
                    .setBasketSubTotal(basketSubTotal)
                    .setCalculatedVatAmount(calculatedVatAmount)
                    .setFinalInvoiceTotal(finalInvoiceTotal)
                    .build();
        }
    }
