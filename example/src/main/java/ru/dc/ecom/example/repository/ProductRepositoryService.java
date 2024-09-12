package ru.dc.ecom.example.repository;

import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.api.dto.ProductDto;
import ru.dc.ecom.example.api.dto.filter.ProductFilter;
import ru.dc.ecom.example.model.ProductEntity;

import java.util.List;

public interface ProductRepositoryService {
    ProductEntity saveProduct(ProductEntity entity);
    List<ProductEntity> findAllProducts();
    ProductEntity findProductById(String id);
    void deleteProductById(String id);

    List<ProductEntity> findByCriteria(ProductFilter productFilter);

}
