package ru.dc.ecom.example.service;

import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.api.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(String id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(String id, ProductDto productDto);

    void deleteProduct(String id);

    List<ProductDto> getFilteredProducts(String name, Pageable pageable);
}
