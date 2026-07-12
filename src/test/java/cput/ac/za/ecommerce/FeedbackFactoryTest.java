package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.*;
import cput.ac.za.ecommerce.factory.ContentModerationFactory;
import cput.ac.za.ecommerce.factory.FeedbackFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/*cput.ac.za.ecommerce.FeedbackFactoryTest.java
    Feedback factory test class
    Author: Abulele Ntwanambi(218276400)
    Date: 27 June 2026
 */

public class FeedbackFactoryTest {
    AccountProfile accountProfile = AccountProfile.builder()
            .setFirstName("Abulele")
            .setLastName("Ntwanambi")
            .setEmail("ntwanambi@gmail.com")
            .setPhoneNumber("0716542389")
            .build();

    Customer customer = Customer.builder()
            .setUserId("C1001")
            .setAccountProfile(accountProfile)
            .setCustomerNumber("CUST-001")
            .build();
    ContentModeration reviewStatus = ContentModerationFactory.createContentModeration(true, null, "Approved");

    DimensionSpecs physicalDimensions = new DimensionSpecs.Builder()
            .setPackageHeightCm(2.5)
            .setPackageWidthCm(24.5)
            .setPackageDepthCm(35.6)
            .setPackageWeightKg(1.8)
            .build();

    HardwareComponent product = (HardwareComponent) new HardwareComponent.Builder()
            .setHardwareCategory("Laptop")
            .setPowerRequirementWatts(65)
            .setComponentFormFactor("Notebook")
            .setProductId("P001")
            .setBrandName("Lenovo")
            .setModelName("ThinkPad X1")
            .setStandardRetailPrice(15000.00)
            .setPhysicalDimensions(physicalDimensions)
            .build();


    @Test
    void testCreateProductReview() {
        ProductReview productReview = FeedbackFactory.createProductReview("F1001", "P001", "CI001",
                LocalDate.of(2026, 06, 27), reviewStatus, customer, product, 3, "Good Product");


        assertNotNull(productReview);
        assertEquals("F1001", productReview.getFeedbackId());
        assertEquals("P001", productReview.getTargetProductId());
        assertEquals("CI001", productReview.getReviewerCustomerId());
        assertEquals(LocalDate.of(2026, 6, 27), productReview.getDateSubmitted());
        assertEquals(3, productReview.getHardwareStarRating());
        assertEquals("Good Product", productReview.getComprehensiveReviewText());
    }

    @Test
    void testCreateProductReviewWithBlankReviewText() {
        assertThrows(IllegalArgumentException.class, () -> {
            FeedbackFactory.createProductReview(
                    "F1001",
                    "P001",
                    "CI001",
                    LocalDate.of(2026, 6, 27),
                    reviewStatus,
                    customer,
                    product,
                    3,
                    ""
            );
        });

    }

    @Test
    void testCreateDeliveryServiceReview() {

        DeliveryServiceReview deliveryServiceReview = FeedbackFactory.createDeliveryServiceReview(
                "F2001",
                "P001",
                "CI001",
                LocalDate.of(2026, 6, 27),
                reviewStatus,
                customer,
                product,
                4,
                "Package arrived in perfect condition"
        );

        assertNotNull(deliveryServiceReview);
        assertEquals("F2001", deliveryServiceReview.getFeedbackId());
        assertEquals("P001", deliveryServiceReview.getTargetProductId());
        assertEquals("CI001", deliveryServiceReview.getReviewerCustomerId());
        assertEquals(LocalDate.of(2026, 6, 27), deliveryServiceReview.getDateSubmitted());
        assertEquals(4, deliveryServiceReview.getCourierFulfillmentRating());
        assertEquals("Package arrived in perfect condition", deliveryServiceReview.getPackageConditionFeedback());
    }

    @Test
    void testCreateDeliveryServiceReviewWithBlankPackageConditionFeedback() {
        assertThrows(IllegalArgumentException.class, () -> {
            FeedbackFactory.createDeliveryServiceReview(
                    "F2001",
                    "P001",
                    "CI001",
                    LocalDate.of(2026, 6, 27),
                    reviewStatus,
                    customer,
                    product,
                    4,
                    ""
            );
        });
    }
}
