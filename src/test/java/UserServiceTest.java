/*
   UserServiceTest.java
   Owenkosi Nxasana (230240887)
   Date: 12 July 2026
 */


import cput.ac.za.ecommerce.domain.AccountProfile;
import cput.ac.za.ecommerce.domain.Administrator;
import cput.ac.za.ecommerce.domain.Customer;
import cput.ac.za.ecommerce.domain.User;
import cput.ac.za.ecommerce.repository.InMemoryUserRepository;
import cput.ac.za.ecommerce.service.UserManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    private UserManagementService userService;

    @BeforeEach
    void setUp() {
        userService = new UserManagementService(new InMemoryUserRepository());
    }

    @Test
    void registerCustomerShouldSaveAndReturnCustomer() {
        AccountProfile profile = createProfile("Ava", "Mokoena", "ava@example.com");

        Customer customer = userService.registerCustomer(profile, "CUST-001");

        assertNotNull(customer);
        assertNotNull(customer.getUserId());
        assertEquals(profile, customer.getAccountProfile());
        assertEquals("CUST-001", customer.getCustomerNumber());
    }

    @Test
    void registerAdministratorShouldSaveAndReturnAdministrator() {
        AccountProfile profile = createProfile("Noah", "Dlamini", "noah@example.com");

        Administrator administrator = userService.registerAdministrator(profile, "EMP-001", "Operations");

        assertNotNull(administrator);
        assertNotNull(administrator.getUserId());
        assertEquals(profile, administrator.getAccountProfile());
        assertEquals("EMP-001", administrator.getEmployeeNumber());
        assertEquals("Operations", administrator.getDepartment());
    }

    @Test
    void getUserShouldReturnRegisteredUser() {
        Customer customer = userService.registerCustomer(
                createProfile("Ava", "Mokoena", "ava@example.com"),
                "CUST-001"
        );

        User foundUser = userService.getUser(customer.getUserId());

        assertEquals(customer.getUserId(), foundUser.getUserId());
    }

    @Test
    void listUsersShouldReturnRegisteredUsers() {
        userService.registerCustomer(createProfile("Ava", "Mokoena", "ava@example.com"), "CUST-001");
        userService.registerAdministrator(createProfile("Noah", "Dlamini", "noah@example.com"), "EMP-001", "Operations");

        List<User> users = userService.listUsers();

        assertEquals(2, users.size());
    }

    @Test
    void updateProfileShouldChangeAccountProfile() {
        Customer customer = userService.registerCustomer(
                createProfile("Ava", "Mokoena", "ava@example.com"),
                "CUST-001"
        );
        AccountProfile updatedProfile = createProfile("Ava", "Mokoena", "ava.new@example.com");

        User updatedUser = userService.updateProfile(customer.getUserId(), updatedProfile);

        assertEquals(updatedProfile, updatedUser.getAccountProfile());
    }

    @Test
    void registerCustomerShouldRejectDuplicateEmail() {
        AccountProfile profile = createProfile("Ava", "Mokoena", "ava@example.com");
        userService.registerCustomer(profile, "CUST-001");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.registerCustomer(profile, "CUST-002")
        );

        assertEquals("Email is already in use.", exception.getMessage());
    }

    @Test
    void getUserShouldThrowExceptionWhenUserDoesNotExist() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUser("missing-id")
        );

        assertTrue(exception.getMessage().contains("User was not found"));
    }

    @Test
    void removeUserShouldDeleteUser() {
        Customer customer = userService.registerCustomer(
                createProfile("Ava", "Mokoena", "ava@example.com"),
                "CUST-001"
        );

        userService.removeUser(customer.getUserId());

        assertThrows(IllegalArgumentException.class, () -> userService.getUser(customer.getUserId()));
    }

    private AccountProfile createProfile(String firstName, String lastName, String email) {
        return AccountProfile.builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber("+27110000000")
                .build();
    }
}
