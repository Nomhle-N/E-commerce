 /*
  * OrderItemFactory.java
  * Author: Sinethemba Nyimbinya (220085870)
  * Date: 2026
  */
 package cput.ac.za.ecommerce.factory;
 import cput.ac.za.ecommerce.domain.OrderItem;
 import java.util.UUID;
 public class OrderItemFactory {

     public static OrderItem createOrderItem(UUID productId,
                                             int quantityPurchased,
                                             double itemPriceSnapshot) {

         if (productId == null)
             return null;

         if (quantityPurchased <= 0)
             return null;

         if (itemPriceSnapshot <= 0)
             return null;

         return new OrderItem.Builder()
                 .setOrderItemId(UUID.randomUUID())
                 .setProductId(productId)
                 .setQuantityPurchased(quantityPurchased)
                 .setItemPriceSnapshot(itemPriceSnapshot)
                 .build();
     }
 }





