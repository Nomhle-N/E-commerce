/* ProductCatalog.java
   Abstract base class for Product Catalog Service
   Author: Nomhle Njengele (216227488)
   Date: 21 June 2026 */

package cput.ac.za.ecommerce.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class ProductCatalog {

    @Id
    private String productId;
    private String brandName;
    private String modelName;
    private double standardRetailPrice;

    @Embedded
    private DimensionSpecs physicalDimensions;

    protected ProductCatalog(Builder builder) {
        this.productId = builder.productId;
        this.brandName = builder.brandName;
        this.modelName = builder.modelName;
        this.standardRetailPrice = builder.standardRetailPrice;
        this.physicalDimensions = builder.physicalDimensions;
    }

    protected ProductCatalog() {}

    public String getProductId() { return productId; }
    public String getBrandName() { return brandName; }
    public String getModelName() { return modelName; }
    public double getStandardRetailPrice() { return standardRetailPrice; }
    public DimensionSpecs getPhysicalDimensions() { return physicalDimensions; }

    public abstract static class Builder {
        private String productId;
        private String brandName;
        private String modelName;
        private double standardRetailPrice;
        private DimensionSpecs physicalDimensions;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder setStandardRetailPrice(double standardRetailPrice) {
            this.standardRetailPrice = standardRetailPrice;
            return this;
        }

        public Builder setPhysicalDimensions(DimensionSpecs physicalDimensions) {
            this.physicalDimensions = physicalDimensions;
            return this;
        }

        public abstract ProductCatalog build();
    }
}