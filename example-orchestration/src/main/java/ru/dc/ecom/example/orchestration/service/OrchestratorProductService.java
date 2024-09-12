package ru.dc.ecom.example.orchestration.service;

import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;

import java.util.List;

public interface OrchestratorProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(String productId, ProductDto productDto);

    ProductDto getProductById(String productId);

    List<ProductDto> getAllProducts();

    void deleteProduct(String productId);

    List<ProductDto> getFilteredProducts(String name, Pageable pageable);
}