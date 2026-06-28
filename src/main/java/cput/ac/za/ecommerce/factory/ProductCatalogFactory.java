/* ProductCatalogFactory.java
   Factory class for ProductCatalog Service
   Author: Nomhle Njengele (216227488)
   Date: 28 June 2026 */

package cput.ac.za.ecommerce.factory;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.HardwareComponent;
import cput.ac.za.ecommerce.domain.PreBuiltSystem;
import cput.ac.za.ecommerce.domain.ProductCatalog;

public class ProductCatalogFactory {

    public static ProductCatalog createProduct(String type,
                                               String productId,
                                               String brandName,
                                               String modelName,
                                               double standardRetailPrice,
                                               DimensionSpecs physicalDimensions) {

        if (type.equals("hardware")) {
            return (HardwareComponent) new HardwareComponent.Builder()
                    .setHardwareCategory("General")
                    .setPowerRequirementWatts(0)
                    .setComponentFormFactor("Standard")
                    .setProductId(productId)
                    .setBrandName(brandName)
                    .setModelName(modelName)
                    .setStandardRetailPrice(standardRetailPrice)
                    .setPhysicalDimensions(physicalDimensions)
                    .build();
        } else if (type.equals("system")) {
            return (PreBuiltSystem) new PreBuiltSystem.Builder()
                    .setSystemTierClassification("Standard")
                    .setWarrantyPeriodMonths(12)
                    .setIsLiquidCooled(false)
                    .setProductId(productId)
                    .setBrandName(brandName)
                    .setModelName(modelName)
                    .setStandardRetailPrice(standardRetailPrice)
                    .setPhysicalDimensions(physicalDimensions)
                    .build();
        }
        throw new IllegalArgumentException("Invalid product type");
    }
}