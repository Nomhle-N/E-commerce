/*
   PaymentRepository
   Ngwana Tiyani (231266731)
   Date: 19 June 2026
 */

package cput.ac.za.ecommerce.repository;

import cput.ac.za.ecommerce.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
