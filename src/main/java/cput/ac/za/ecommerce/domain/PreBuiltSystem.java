/* PreBuiltSystem.java
   Entity for Product Catalog Service
   Author: Nomhle Njengele (216227488)
   Date: 21 June 2026 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pre_built_system")
public class PreBuiltSystem extends ProductCatalog {

    private String systemTierClassification;
    private int warrantyPeriodMonths;
    private boolean isLiquidCooled;

    private PreBuiltSystem(Builder builder) {
        super(builder);
        this.systemTierClassification = builder.systemTierClassification;
        this.warrantyPeriodMonths = builder.warrantyPeriodMonths;
        this.isLiquidCooled = builder.isLiquidCooled;
    }

    protected PreBuiltSystem() {}

    public String getSystemTierClassification() { return systemTierClassification; }
    public int getWarrantyPeriodMonths() { return warrantyPeriodMonths; }
    public boolean isLiquidCooled() { return isLiquidCooled; }

    public static class Builder extends ProductCatalog.Builder {
        private String systemTierClassification;
        private int warrantyPeriodMonths;
        private boolean isLiquidCooled;

        public Builder setSystemTierClassification(String systemTierClassification) {
            this.systemTierClassification = systemTierClassification;
            return this;
        }

        public Builder setWarrantyPeriodMonths(int warrantyPeriodMonths) {
            this.warrantyPeriodMonths = warrantyPeriodMonths;
            return this;
        }

        public Builder setIsLiquidCooled(boolean isLiquidCooled) {
            this.isLiquidCooled = isLiquidCooled;
            return this;
        }

        public PreBuiltSystem build() {
            return new PreBuiltSystem(this);
        }
    }
}