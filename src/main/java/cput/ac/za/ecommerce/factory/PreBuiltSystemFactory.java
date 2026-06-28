/* PreBuiltSystemFactory.java
   Factory class for PreBuiltSystem
   Author: Nomhle Njengele (216227488)
   Date: 27 June 2026 */

package cput.ac.za.ecommerce.factory;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.PreBuiltSystem;

public class PreBuiltSystemFactory {

    public static PreBuiltSystem createPreBuiltSystem(
            String productId,
            String brandName,
            String modelName,
            double standardRetailPrice,
            DimensionSpecs physicalDimensions,
            String systemTierClassification,
            int warrantyPeriodMonths,
            boolean isLiquidCooled) {

        return (PreBuiltSystem) new PreBuiltSystem.Builder()
                .setSystemTierClassification(systemTierClassification)
                .setWarrantyPeriodMonths(warrantyPeriodMonths)
                .setIsLiquidCooled(isLiquidCooled)
                .setProductId(productId)
                .setBrandName(brandName)
                .setModelName(modelName)
                .setStandardRetailPrice(standardRetailPrice)
                .setPhysicalDimensions(physicalDimensions)
                .build();
    }
}
