package cput.ac.za.ecommerce.repository;

import cput.ac.za.ecommerce.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
