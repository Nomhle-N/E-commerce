package cput.ac.za.ecommerce.domain;
/*
  ShipmentTracking.java
  Entity for shipment tracking
  Author: Sinazo Ntsimbi(222765208)
  Date: 19 June 2026
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ShipmentTracking {

    @Id
    private String trackingId;

    private String currentLocation;

    private String statusUpdate;

    private LocalDateTime updateTimestamp;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    protected ShipmentTracking() {
    }

    private ShipmentTracking(Builder builder) {
        this.trackingId = builder.trackingId;
        this.currentLocation = builder.currentLocation;
        this.statusUpdate = builder.statusUpdate;
        this.updateTimestamp = builder.updateTimestamp;
        this.delivery = builder.delivery;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return "ShipmentTracking{" +
                "trackingId='" + trackingId + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", statusUpdate='" + statusUpdate + '\'' +
                ", updateTimestamp=" + updateTimestamp +
                '}';
    }

    public static class Builder {

        private String trackingId;
        private String currentLocation;
        private String statusUpdate;
        private LocalDateTime updateTimestamp;
        private Delivery delivery;

        public Builder setTrackingId(String trackingId) {
            this.trackingId = trackingId;
            return this;
        }

        public Builder setCurrentLocation(String currentLocation) {
            this.currentLocation = currentLocation;
            return this;
        }

        public Builder setStatusUpdate(String statusUpdate) {
            this.statusUpdate = statusUpdate;
            return this;
        }

        public Builder setUpdateTimestamp(LocalDateTime updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public Builder setDelivery(Delivery delivery) {
            this.delivery = delivery;
            return this;
        }

        public Builder copy(ShipmentTracking tracking) {
            this.trackingId = tracking.trackingId;
            this.currentLocation = tracking.currentLocation;
            this.statusUpdate = tracking.statusUpdate;
            this.updateTimestamp = tracking.updateTimestamp;
            this.delivery = tracking.delivery;
            return this;
        }

        public ShipmentTracking build() {
            return new ShipmentTracking(this);
        }
    }
}
