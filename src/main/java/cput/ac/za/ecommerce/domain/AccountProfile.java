package cput.ac.za.ecommerce.domain;
/*
   AccountProfile.java
   Owenkosi Nxasana (230240887)
   Date: 20 June 2026
 */
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AccountProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private AccountProfile(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    protected AccountProfile() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public AccountProfile withEmail(String newEmail) {
        return AccountProfile.builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(newEmail)
                .setPhoneNumber(phoneNumber)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountProfile that)) {
            return false;
        }
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(email, that.email)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "AccountProfile{"
                + "fullName='" + getFullName() + '\''
                + ", email='" + email + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;

        private Builder() {
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AccountProfile build() {
            if (firstName == null || firstName.isEmpty()) {
                return null;
            }
            if (lastName == null || lastName.isEmpty()) {
                return null;
            }
            if (email == null || email.isEmpty()) {
                return null;
            }

            return new AccountProfile(this);
        }
    }
}
