package ru.dc.ecom.example.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.dc.ecom.example.api.dto.filter.ProductFilter;
import ru.dc.ecom.example.model.ProductEntity;
import ru.dc.ecom.example.repository.ProductRepository;
import ru.dc.ecom.example.repository.ProductRepositoryService;
import ru.dc.ecom.example.repository.specification.ProductCriteriaBuilder;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    public ProductEntity saveProduct(ProductEntity entity) {
        return productRepository.save(entity);
    }

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    public List<ProductEntity> findByCriteria(ProductFilter filter) {
        Criteria criteria = buildCriteria(filter);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, ProductEntity.class);
    }

    private Criteria buildCriteria(ProductFilter filter) {
        ProductCriteriaBuilder criteriaBuilder = new ProductCriteriaBuilder();
        return criteriaBuilder.build(filter);
    }
}
