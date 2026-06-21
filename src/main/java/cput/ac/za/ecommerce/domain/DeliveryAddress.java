package cput.ac.za.ecommerce.domain;
/*
  DeliveryAddress.java
  Value Object for delivery address
  Author: Sinazo Ntsimbi(222765208)
  Date:19 June 2026
 */
import jakarta.persistence.Embeddable;
@Embeddable
public class DeliveryAddress {

    private String streetAddress;
    private String suburb;
    private String city;
    private String postalCode;

    protected DeliveryAddress() {
    }

    private DeliveryAddress(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "streetAddress='" + streetAddress + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String streetAddress;
        private String suburb;
        private String city;
        private String postalCode;

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(DeliveryAddress address) {
            this.streetAddress = address.streetAddress;
            this.suburb = address.suburb;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public DeliveryAddress build() {
            return new DeliveryAddress(this);
        }
    }
}
