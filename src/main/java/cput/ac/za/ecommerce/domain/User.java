package cput.ac.za.ecommerce.domain;
/*
   User.java
   Owenkosi Nxasana (230240887)
   Date: 20 June 2026
 */
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    private String userId;

    @Embedded
    private AccountProfile accountProfile;

    protected User(Builder<?> builder) {
        this.userId = builder.userId;
        this.accountProfile = builder.accountProfile;
    }

    protected User() {
    }

    public String getUserId() {
        return userId;
    }

    public AccountProfile getAccountProfile() {
        return accountProfile;
    }

    public abstract UserRole getRole();

    public void updateProfile(AccountProfile accountProfile) {
        this.accountProfile = accountProfile;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId='" + userId + '\''
                + ", role=" + getRole()
                + ", accountProfile=" + accountProfile
                + '}';
    }

    protected abstract static class Builder<T extends Builder<T>> {
        protected String userId;
        protected AccountProfile accountProfile;

        public T setUserId(String userId) {
            this.userId = userId;
            return self();
        }

        public T setAccountProfile(AccountProfile accountProfile) {
            this.accountProfile = accountProfile;
            return self();
        }

        protected boolean baseFieldsAreValid() {
            return userId != null && !userId.isEmpty() && accountProfile != null;
        }

        protected abstract T self();
    }
}
