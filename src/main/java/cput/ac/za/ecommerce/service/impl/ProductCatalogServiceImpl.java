/* ProductCatalogServiceImpl.java
   Service implementation for Product Catalog Service
   Author: Nomhle Njengele (216227488)
   Date: 12 July 2026 */

package cput.ac.za.ecommerce.service.impl;

import cput.ac.za.ecommerce.domain.ProductCatalog;
import cput.ac.za.ecommerce.repository.ProductCatalogRepository;
import cput.ac.za.ecommerce.service.IProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogServiceImpl implements IProductCatalogService {

    private final ProductCatalogRepository repository;

    private static ProductCatalogServiceImpl service = null;

    @Autowired
    public ProductCatalogServiceImpl(ProductCatalogRepository repository) {
        this.repository = repository;
        service = this;
    }

    @Override
    public ProductCatalog saveProductCatalog(ProductCatalog productCatalog) {
        if (productCatalog == null) return null;
        return repository.save(productCatalog);
    }

    @Override
    public ProductCatalog getProductCatalogById(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductCatalog> getAllProductCatalogs() {
        return repository.findAll();
    }

    @Override
    public ProductCatalog updateProductCatalog(ProductCatalog productCatalog) {
        if (productCatalog == null) return null;
        return repository.save(productCatalog);
    }

    @Override
    public void deleteProductCatalog(String productId) {
        repository.deleteById(productId);
    }
}
