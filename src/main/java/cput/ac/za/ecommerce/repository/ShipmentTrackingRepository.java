package cput.ac.za.ecommerce.repository;
/*
 Repository for Shipment tracking
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */
import cput.ac.za.ecommerce.domain.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, String> {
}