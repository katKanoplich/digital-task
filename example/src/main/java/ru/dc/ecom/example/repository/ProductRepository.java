package ru.dc.ecom.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.dc.ecom.example.model.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}

