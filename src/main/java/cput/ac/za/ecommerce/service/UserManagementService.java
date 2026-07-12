package cput.ac.za.ecommerce.service;
/*
   UserManagementService.java
   Owenkosi Nxasana (230240887)
   Date: 12 July 2026
 */

import cput.ac.za.ecommerce.domain.AccountProfile;
import cput.ac.za.ecommerce.domain.Administrator;
import cput.ac.za.ecommerce.domain.Customer;
import cput.ac.za.ecommerce.domain.User;
import cput.ac.za.ecommerce.factory.UserManagementFactory;
import cput.ac.za.ecommerce.repository.UserManagementRepository;

import java.util.List;

public final class UserManagementService {
    private final UserManagementRepository userRepository;

    public UserManagementService(UserManagementRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer registerCustomer(AccountProfile profile, String customerNumber) {
        ensureEmailIsUnique(profile.getEmail());
        Customer customer = UserManagementFactory.createCustomer(profile, customerNumber);
        if (customer == null) {
            throw new IllegalArgumentException("Customer details are invalid.");
        }
        return (Customer) userRepository.save(customer);
    }

    public Administrator registerAdministrator(AccountProfile profile, String employeeNumber, String department) {
        ensureEmailIsUnique(profile.getEmail());
        Administrator administrator = UserManagementFactory.createAdministrator(profile, employeeNumber, department);
        if (administrator == null) {
            throw new IllegalArgumentException("Administrator details are invalid.");
        }
        return (Administrator) userRepository.save(administrator);
    }

    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User was not found: " + userId));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User updateProfile(String userId, AccountProfile profile) {
        User user = getUser(userId);
        userRepository.findByEmail(profile.getEmail())
                .filter(existing -> !existing.getUserId().equals(userId))
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Email is already in use.");
                });
        user.updateProfile(profile);
        return userRepository.save(user);
    }

    public void removeUser(String userId) {
        userRepository.deleteById(userId);
    }

    private void ensureEmailIsUnique(String email) {
        userRepository.findByEmail(email).ifPresent(existing -> {
            throw new IllegalArgumentException("Email is already in use.");
        });
    }
}

