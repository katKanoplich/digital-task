package ru.dc.ecom.example.orchestration.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;
import ru.dc.ecom.example.orchestration.service.OrchestratorProductService;
import ru.dc.ecom.example.orchestration.service.ProductServiceClient;

import java.util.List;

@Service
@Slf4j
public class OrchestratorProductServiceImpl implements OrchestratorProductService {

    private final ProductServiceClient productServiceClient;

    @Autowired
    public OrchestratorProductServiceImpl(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.debug("Orchestrator: Creating product");
        return productServiceClient.createProduct(productDto);
    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto productDto) {
        log.debug("Orchestrator: Updating product with ID: {}", productId);
        return productServiceClient.updateProduct(productId, productDto);
    }

    @Override
    public ProductDto getProductById(String productId) {
        log.debug("Orchestrator: Fetching product with ID: {}", productId);
        return productServiceClient.getProductById(productId);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.debug("Orchestrator: Fetching all products");
        return productServiceClient.getAllProducts();
    }

    @Override
    public void deleteProduct(String productId) {
        log.debug("Orchestrator: Deleting product with ID: {}", productId);
        productServiceClient.deleteProduct(productId);
    }

    @Override
    public List<ProductDto> getFilteredProducts(String name, Pageable pageable) {
        log.debug("Orchestrator: Filtering products with Name: {}", name);
        return productServiceClient.getFilteredProducts(name, pageable.getPageNumber());
    }
}