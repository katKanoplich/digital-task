package ru.dc.ecom.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dc.ecom.example.api.dto.ProductDto;
import ru.dc.ecom.example.api.dto.filter.ProductFilter;
import ru.dc.ecom.example.converter.ProductConverter;
import ru.dc.ecom.example.model.ProductEntity;
import ru.dc.ecom.example.repository.ProductRepositoryService;
import ru.dc.ecom.example.repository.impl.ProductRepositoryServiceImpl;
import ru.dc.ecom.example.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryService productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity entity = productConverter.convertToEntity(productDto);
        ProductEntity savedEntity = productRepository.saveProduct(entity);
        return productConverter.convertToDto(savedEntity);
    }

    @Override
    public ProductDto getProductById(String id) {
        ProductEntity entity = productRepository.findProductById(id);
        return Optional.ofNullable(entity)
                .map(productConverter::convertToDto)
                .orElse(null);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> entities = productRepository.findAllProducts();
        return entities.stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        ProductEntity existingEntity = productRepository.findProductById(id);
        if (existingEntity == null) {
            throw new RuntimeException("Product not found");
        }
        productConverter.updateEntity(existingEntity, productDto);
        ProductEntity savedEntity = productRepository.saveProduct(existingEntity);
        return productConverter.convertToDto(savedEntity);
    }
    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProductById(id);
    }
    @Override
    public List<ProductDto> getFilteredProducts(String name, Pageable pageable) {
        ProductFilter filter = ProductFilter.builder()
                .name(name)
                .build();

        List<ProductEntity> entities = productRepository.findByCriteria(filter);

        return entities.stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

}