/* ProductCatalogFactoryTest.java
   Factory Test class for ProductCatalog
   Author: Nomhle Njengele (216227488)
   Date: 28 June 2026 */

package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.DimensionSpecs;
import cput.ac.za.ecommerce.domain.ProductCatalog;
import cput.ac.za.ecommerce.factory.ProductCatalogFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogFactoryTest {

    @Test
    void testCreateHardwareProduct() {
        DimensionSpecs dimensions = new DimensionSpecs.Builder()
                .setPackageHeightCm(10.0)
                .setPackageWidthCm(8.0)
                .setPackageDepthCm(2.0)
                .setPackageWeightKg(0.2)
                .build();

        ProductCatalog product = ProductCatalogFactory.createProduct(
                "hardware",
                "P001",
                "Samsung",
                "970 EVO Plus",
                1500.00,
                dimensions
        );

        assertNotNull(product);
    }

    @Test
    void testCreateSystemProduct() {
        DimensionSpecs dimensions = new DimensionSpecs.Builder()
                .setPackageHeightCm(45.0)
                .setPackageWidthCm(20.0)
                .setPackageDepthCm(40.0)
                .setPackageWeightKg(8.5)
                .build();

        ProductCatalog product = ProductCatalogFactory.createProduct(
                "system",
                "P002",
                "Samsung",
                "Galaxy Book Pro",
                25000.00,
                dimensions
        );

        assertNotNull(product);
    }
}