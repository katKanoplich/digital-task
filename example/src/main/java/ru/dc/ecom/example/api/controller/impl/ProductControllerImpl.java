package ru.dc.ecom.example.api.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.ecom.example.api.controller.ProductController;
import ru.dc.ecom.example.api.dto.ProductDto;
import ru.dc.ecom.example.service.ProductService;

import java.util.List;

@RestController
@Slf4j
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto productDto) {
        log.debug("Event=UPDATE_ROUTE, Msg='Start updating product with ID: {} and data: {}'", productId, productDto);
        ProductDto product = productService.updateProduct(productId, productDto);
        log.debug("Event=UPDATE_Product, Msg='Success in updating product: {}'", product);
        return product;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.debug("Event=CREATE_ROUTE, Msg='Start creating product with data: {}'", productDto);
        ProductDto createdProduct = productService.createProduct(productDto);
        log.debug("Event=CREATE_product, Msg='Success in creating product: {}'", createdProduct);
        return createdProduct;
    }

    @Override
    public ProductDto getProductById(String productId) {
        log.debug("Event=GET_ROUTE, Msg='Fetching product with ID: {}'", productId);
        ProductDto product = productService.getProductById(productId);
        if (product == null) {
            log.warn("Event=GET_product, Msg='product not found for ID: {}'", productId);
            throw new RuntimeException("product not found");
        }
        return product;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.debug("Event=GET_ALL_ROUTE, Msg='Fetching all products'");
        return productService.getAllProducts();
    }

    @Override
    public void deleteProduct(String productId) {
        log.debug("Event=DELETE_ROUTE, Msg='Deleting product with ID: {}'", productId);
        productService.deleteProduct(productId);
        log.debug("Event=DELETE_product, Msg='Successfully deleted product with ID: {}'", productId);
    }
    @Override
    public List<ProductDto> getFilteredProducts(String name, Pageable pageable) {
        log.debug("Event=FILTER_ROUTE, Msg='Filtering products with Name: {} on page: {}'", name, pageable.getPageNumber());
        List<ProductDto> filteredProducts = productService.getFilteredProducts(name, pageable);
        log.debug("Event=FILTER_productS, Msg='Filtered products count: {}'", filteredProducts.size());
        return filteredProducts;
    }

}