package cput.ac.za.ecommerce.domain;
/*
   Customer.java
   Owenkosi Nxasana (230240887)
   Date: 20 June 2026
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends User {
    private String customerNumber;

    private Customer(Builder builder) {
        super(builder);
        this.customerNumber = builder.customerNumber;
    }

    protected Customer() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    @Override
    public UserRole getRole() {
        return UserRole.CUSTOMER;
    }

    public static class Builder extends User.Builder<Builder> {
        private String customerNumber;

        private Builder() {
        }

        public Builder setCustomerNumber(String customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Customer build() {
            if (!baseFieldsAreValid()) {
                return null;
            }
            if (customerNumber == null || customerNumber.isEmpty()) {
                return null;
            }

            return new Customer(this);
        }
    }
}