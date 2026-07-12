/* ProductCatalogService.java
   Service interface for Product Catalog Service
   Author: Nomhle Njengele (216227488)
   Date: 11 July 2026 */

package cput.ac.za.ecommerce.service;

import cput.ac.za.ecommerce.domain.ProductCatalog;
import java.util.List;

public interface IProductCatalogService {
    ProductCatalog saveProductCatalog(ProductCatalog productCatalog);
    ProductCatalog getProductCatalogById(String productId);
    List<ProductCatalog> getAllProductCatalogs();
    ProductCatalog updateProductCatalog(ProductCatalog productCatalog);
    void deleteProductCatalog(String productId);
}
