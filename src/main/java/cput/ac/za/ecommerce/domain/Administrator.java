package cput.ac.za.ecommerce.domain;
/*
   Administrator.java
   Owenkosi Nxasana (230240887)
   Date: 20 June 2026
 */
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator extends User {
    private String employeeNumber;
    private String department;

    private Administrator(Builder builder) {
        super(builder);
        this.employeeNumber = builder.employeeNumber;
        this.department = builder.department;
    }

    protected Administrator() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMINISTRATOR;
    }

    public static class Builder extends User.Builder<Builder> {
        private String employeeNumber;
        private String department;

        private Builder() {
        }

        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Administrator build() {
            if (!baseFieldsAreValid()) {
                return null;
            }
            if (employeeNumber == null || employeeNumber.isEmpty()) {
                return null;
            }
            if (department == null || department.isEmpty()) {
                return null;
            }

            return new Administrator(this);
        }
    }
}
