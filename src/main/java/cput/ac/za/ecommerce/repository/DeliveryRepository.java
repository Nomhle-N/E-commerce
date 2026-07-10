package cput.ac.za.ecommerce.repository;
/*
 Repository for Delivery
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */
import cput.ac.za.ecommerce.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {
}

