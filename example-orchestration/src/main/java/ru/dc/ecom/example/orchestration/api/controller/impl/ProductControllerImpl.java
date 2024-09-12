package ru.dc.ecom.example.orchestration.api.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.ecom.example.orchestration.api.controller.ProductController;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;
import ru.dc.ecom.example.orchestration.service.OrchestratorProductService;

import java.util.List;

@RestController
@Slf4j
public class ProductControllerImpl implements ProductController {

    private final OrchestratorProductService orchestratorService;

    public ProductControllerImpl(OrchestratorProductService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto productDto) {
        log.debug("Event=UPDATE_ROUTE, Msg='Start updating product with ID: {}'", productId);
        return orchestratorService.updateProduct(productId, productDto);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.debug("Event=CREATE_ROUTE, Msg='Start creating product with data: {}'", productDto);
        return orchestratorService.createProduct(productDto);
    }

    @Override
    public ProductDto getProductById(String productId) {
        log.debug("Event=GET_ROUTE, Msg='Fetching product with ID: {}'", productId);
        return orchestratorService.getProductById(productId);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.debug("Event=GET_ALL_ROUTE, Msg='Fetching all products'");
        return orchestratorService.getAllProducts();
    }

    @Override
    public void deleteProduct(String productId) {
        log.debug("Event=DELETE_ROUTE, Msg='Deleting product with ID: {}'", productId);
        orchestratorService.deleteProduct(productId);
    }

    @Override
    public List<ProductDto> getFilteredProducts(String name, Pageable pageable) {
        log.debug("Event=FILTER_ROUTE, Msg='Filtering products with Name: {}'", name);
        return orchestratorService.getFilteredProducts(name, pageable);
    }
}