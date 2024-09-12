package ru.dc.ecom.example.orchestration.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;

import java.util.List;

@Tag(name = "Product", description = "Product API")
@RequestMapping("product/v1/products")
public interface ProductController {

    @PutMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a Product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ProductDto updateProduct(
            @Parameter(description = "Id of a Product. Cannot be empty.", required = true)
            @PathVariable("productId") String productId,
            @Validated @RequestBody ProductDto product);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Product")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDto createProduct(
            @Validated @RequestBody ProductDto product);

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a Product by ID")
    @ResponseStatus(HttpStatus.OK)
    ProductDto getProductById(
            @Parameter(description = "Id of a Product. Cannot be empty.", required = true)
            @PathVariable("productId") String productId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all Products")
    @ResponseStatus(HttpStatus.OK)
    List<ProductDto> getAllProducts();

    @DeleteMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a Product by ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(
            @Parameter(description = "Id of a Product. Cannot be empty.", required = true)
            @PathVariable("productId") String productId);

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get filtered Products by name and pageable")
    @ResponseStatus(HttpStatus.OK)
    List<ProductDto> getFilteredProducts(
            @Parameter(description = "Name of the Product to filter by", required = true)
            @RequestParam String name,
            @Parameter(description = "Pagination information", required = true)
            Pageable pageable);
}