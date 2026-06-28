/* HardwareComponentFactory.java
Factory class for HardwareComponent
Author: Nomhle Njengele (216227488)
Date: 27 June 2026 */

        package cput.ac.za.ecommerce.factory;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.HardwareComponent;

public class HardwareComponentFactory {

    public static HardwareComponent createHardwareComponent(
            String productId,
            String brandName,
            String modelName,
            double standardRetailPrice,
            DimensionSpecs physicalDimensions,
            String hardwareCategory,
            int powerRequirementWatts,
            String componentFormFactor) {

        return (HardwareComponent) new HardwareComponent.Builder()
                .setHardwareCategory(hardwareCategory)
                .setPowerRequirementWatts(powerRequirementWatts)
                .setComponentFormFactor(componentFormFactor)
                .setProductId(productId)
                .setBrandName(brandName)
                .setModelName(modelName)
                .setStandardRetailPrice(standardRetailPrice)
                .setPhysicalDimensions(physicalDimensions)
                .build();
    }
}