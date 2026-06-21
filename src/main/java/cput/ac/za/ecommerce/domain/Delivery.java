package cput.ac.za.ecommerce.domain;
/*
 Delivery.java
 Entity for delivery management
 Author: Sinazo Ntsimbi(222765208)
 Date: 19 June 2026
 */
import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    private String deliveryId;

    private String orderId;

    private String trackingNumber;

    private String deliveryStatus;

    @Embedded
    private DeliveryAddress deliveryAddress;

    protected Delivery() {
    }

    private Delivery(Builder builder) {
        this.deliveryId = builder.deliveryId;
        this.orderId = builder.orderId;
        this.trackingNumber = builder.trackingNumber;
        this.deliveryStatus = builder.deliveryStatus;
        this.deliveryAddress = builder.deliveryAddress;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                '}';
    }

    public static class Builder {

        private String deliveryId;
        private String orderId;
        private String trackingNumber;
        private String deliveryStatus;
        private DeliveryAddress deliveryAddress;

        public Builder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public Builder setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }

        public Builder setDeliveryAddress(DeliveryAddress deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder copy(Delivery delivery) {
            this.deliveryId = delivery.deliveryId;
            this.orderId = delivery.orderId;
            this.trackingNumber = delivery.trackingNumber;
            this.deliveryStatus = delivery.deliveryStatus;
            this.deliveryAddress = delivery.deliveryAddress;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }


    }
}
