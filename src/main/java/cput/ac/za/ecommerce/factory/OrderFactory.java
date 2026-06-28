/*
 * OrderFactory.java
 * Author: Sinethemba Nyimbinya (220085870)
 * Date: 2026
 */
package cput.ac.za.ecommerce.factory;

import cput.ac.za.ecommerce.domain.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderFactory {

    public static Order createOrder(UUID customerId,
                                    String currentOrderStatus,
                                    List<OrderItem> orderLineItems,
                                    FinancialBreakdown dynamicTotals) {

        if (customerId == null)
            return null;

        if (currentOrderStatus == null || currentOrderStatus.isBlank())
            return null;

        if (orderLineItems == null || orderLineItems.isEmpty())
            return null;

        if (dynamicTotals == null)
            return null;

        return new Order.Builder()
                .setOrderId(UUID.randomUUID())
                .setCustomerId(customerId)
                .setDateCreated(LocalDateTime.now())
                .setCurrentOrderStatus(currentOrderStatus)
                .setOrderLineItems(orderLineItems)
                .setDynamicTotals(dynamicTotals)
                .build();
    }
}
