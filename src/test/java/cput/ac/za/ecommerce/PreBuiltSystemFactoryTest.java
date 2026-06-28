/* PreBuiltSystemFactoryTest.java
   Factory Test class for PreBuiltSystem
   Author: Nomhle Njengele (216227488)
   Date: 28 June 2026 */

package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.PreBuiltSystem;
import cput.ac.za.ecommerce.factory.PreBuiltSystemFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PreBuiltSystemFactoryTest {

    @Test
    void testCreatePreBuiltSystem() {
        DimensionSpecs dimensions = new DimensionSpecs.Builder()
                .setPackageHeightCm(45.0)
                .setPackageWidthCm(20.0)
                .setPackageDepthCm(40.0)
                .setPackageWeightKg(8.5)
                .build();

        PreBuiltSystem system = PreBuiltSystemFactory.createPreBuiltSystem(
                "PBS001",
                "Samsung",
                "Galaxy Book Pro",
                25000.00,
                dimensions,
                "High-End",
                24,
                true
        );

        assertNotNull(system);
    }
}