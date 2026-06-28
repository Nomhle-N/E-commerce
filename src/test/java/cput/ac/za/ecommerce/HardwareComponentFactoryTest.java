/* HardwareComponentFactoryTest.java
   Factory Test class for HardwareComponent
   Author: Nomhle Njengele (216227488)
   Date: 28 June 2026 */

package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.HardwareComponent;
import cput.ac.za.ecommerce.factory.HardwareComponentFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HardwareComponentFactoryTest {

    @Test
    void testCreateHardwareComponent() {
        DimensionSpecs dimensions = new DimensionSpecs.Builder()
                .setPackageHeightCm(10.0)
                .setPackageWidthCm(8.0)
                .setPackageDepthCm(2.0)
                .setPackageWeightKg(0.2)
                .build();

        HardwareComponent hardware = HardwareComponentFactory.createHardwareComponent(
                "HWC001",
                "Samsung",
                "970 EVO Plus",
                1500.00,
                dimensions,
                "SSD",
                1000,
                "M.2 NVMe"
        );

        assertNotNull(hardware);
    }
}