package cput.ac.za.ecommerce;
/*
   UserManagementFactoryTest.java
   Owenkosi Nxasana (230240887)
   Date: 27 June 2026
 */
import cput.ac.za.ecommerce.domain.AccountProfile;
import cput.ac.za.ecommerce.domain.Administrator;
import cput.ac.za.ecommerce.domain.Customer;
import cput.ac.za.ecommerce.domain.UserRole;
import cput.ac.za.ecommerce.factory.UserManagementFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserManagementFactoryTest {

    @Test
    void createCustomerShouldReturnValidCustomer() {
        AccountProfile profile = createProfile();

        Customer customer = UserManagementFactory.createCustomer(profile, "CUST-001");

        assertNotNull(customer);
        assertNotNull(customer.getUserId());
        assertTrue(customer.getUserId().startsWith("USR-"));
        assertEquals(profile, customer.getAccountProfile());
        assertEquals("CUST-001", customer.getCustomerNumber());
        assertEquals(UserRole.CUSTOMER, customer.getRole());
    }

    @Test
    void createAdministratorShouldReturnValidAdministrator() {
        AccountProfile profile = createProfile();

        Administrator administrator = UserManagementFactory.createAdministrator(profile, "EMP-001", "Operations");

        assertNotNull(administrator);
        assertNotNull(administrator.getUserId());
        assertTrue(administrator.getUserId().startsWith("USR-"));
        assertEquals(profile, administrator.getAccountProfile());
        assertEquals("EMP-001", administrator.getEmployeeNumber());
        assertEquals("Operations", administrator.getDepartment());
        assertEquals(UserRole.ADMINISTRATOR, administrator.getRole());
    }

    @Test
    void createCustomerShouldReturnNullWhenProfileIsMissing() {
        Customer customer = UserManagementFactory.createCustomer(null, "CUST-001");

        assertNull(customer);
    }

    @Test
    void createAdministratorShouldReturnNullWhenRequiredDetailsAreMissing() {
        AccountProfile profile = createProfile();

        Administrator administrator = UserManagementFactory.createAdministrator(profile, "", "Operations");

        assertNull(administrator);
    }

    private AccountProfile createProfile() {
        return AccountProfile.builder()
                .setFirstName("Ava")
                .setLastName("Mokoena")
                .setEmail("ava@example.com")
                .setPhoneNumber("+27110000000")
                .build();
    }
}

