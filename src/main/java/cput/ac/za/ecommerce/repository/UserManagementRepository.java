package cput.ac.za.ecommerce.repository;
/*
   UserManagementRepsitory.java
   Owenkosi Nxasana (230240887)
   Date: 12 July 2026
 */
import cput.ac.za.ecommerce.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserManagementRepository {
    User save(User user);

    Optional<User> findById(String userId);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void deleteById(String userId);
}
