/*
   BillingLocation.java
   Ngwana Tiyani (231266731)
   Date: 20 June 2026
 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.Embeddable;

@Embeddable

//ValueObject
public class BillingLocation
{
    private String billingStreet;
    private String billingCity;
    private String billingPostalCode;

    protected BillingLocation(){}

    public String getBillingStreet() {return billingStreet;}
    public String getBillingCity() {return billingCity;}
    public String getBillingPostalCode() {return billingPostalCode;}

    @Override
    public String toString() {
        return "BillingLocation{" +
                "billingStreet='" + billingStreet + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                '}';
    }

    private BillingLocation(Builder builder)
    {
        this.billingStreet = builder.billingStreet;
        this.billingCity = builder.billingCity;
        this.billingPostalCode = builder.billingPostalCode;
    }

    public static class Builder
    {
        private String billingStreet;
        private String billingCity;
        private String billingPostalCode;

        public  Builder billingStreet(String billingStreet)
        {
            this.billingStreet = billingStreet;
            return this;
        }
        public Builder billingCity(String billingCity)
        {
            this.billingCity = billingCity;
            return this;
        }
        public Builder billingPostalCode(String billingPostalCode) {
            this.billingPostalCode = billingPostalCode;
            return this;
        }
        public BillingLocation build()
        {
            return new BillingLocation(this);
        }
    }
}

