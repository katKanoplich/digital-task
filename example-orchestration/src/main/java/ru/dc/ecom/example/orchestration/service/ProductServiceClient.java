package ru.dc.ecom.example.orchestration.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;

import java.util.List;

@FeignClient(name = "productService", url = "${product.service.url}")
public interface ProductServiceClient {

    @PostMapping("/products")
    ProductDto createProduct(ProductDto productDto);

    @PutMapping("/products/{productId}")
    ProductDto updateProduct(@PathVariable("productId") String productId, @RequestBody ProductDto productDto);

    @GetMapping("/products/{productId}")
    ProductDto getProductById(@PathVariable("productId") String productId);

    @GetMapping("/products")
    List<ProductDto> getAllProducts();

    @DeleteMapping("/products/{productId}")
    void deleteProduct(@PathVariable("productId") String productId);

    @GetMapping("/products/filter")
    List<ProductDto> getFilteredProducts(@RequestParam("name") String name, @RequestParam("page") int page);
}