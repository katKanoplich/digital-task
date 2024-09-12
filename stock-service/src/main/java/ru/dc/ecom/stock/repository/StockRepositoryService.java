package ru.dc.ecom.stock.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.dc.ecom.stock.api.dto.filter.StockFilter;
import ru.dc.ecom.stock.model.StockEntity;
import ru.dc.ecom.stock.repository.specification.StockSpecification;

import java.util.List;

public interface StockRepositoryService {
    StockEntity saveStock(StockEntity entity);
    List<StockEntity> findAllStocks();
    StockEntity findStockById(long id);
    void deleteStockById(long id);

    List<StockEntity> findByCriteria(Specification<StockEntity> spec, Pageable pageable);

}
