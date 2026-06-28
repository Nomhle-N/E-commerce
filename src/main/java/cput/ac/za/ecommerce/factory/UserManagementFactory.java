package cput.ac.za.ecommerce.factory;
/*
   UserManagementFactory.java
   Owenkosi Nxasana (230240887)
   Date: 27 June 2026
 */
import cput.ac.za.ecommerce.domain.AccountProfile;
import cput.ac.za.ecommerce.domain.Administrator;
import cput.ac.za.ecommerce.domain.Customer;
import java.util.UUID;

public final class UserManagementFactory {
    private UserManagementFactory() {
    }

    public static Customer createCustomer(AccountProfile profile, String customerNumber) {
        return Customer.builder()
                .setUserId(generateUserId())
                .setAccountProfile(profile)
                .setCustomerNumber(customerNumber)
                .build();
    }

    public static Administrator createAdministrator(AccountProfile profile, String employeeNumber, String department) {
        return Administrator.builder()
                .setUserId(generateUserId())
                .setAccountProfile(profile)
                .setEmployeeNumber(employeeNumber)
                .setDepartment(department)
                .build();
    }

    private static String generateUserId() {
        return "USR-" + UUID.randomUUID();
    }
}

