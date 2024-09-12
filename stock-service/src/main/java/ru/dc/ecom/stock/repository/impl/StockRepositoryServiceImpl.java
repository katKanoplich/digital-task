package ru.dc.ecom.stock.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import ru.dc.ecom.stock.api.dto.filter.StockFilter;
import ru.dc.ecom.stock.model.StockEntity;
import ru.dc.ecom.stock.repository.StockRepository;
import ru.dc.ecom.stock.repository.StockRepositoryService;
import ru.dc.ecom.stock.repository.specification.StockSpecification;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class StockRepositoryServiceImpl implements StockRepositoryService {

    private final StockRepository stockRepository;

    @Override
    public StockEntity saveStock(StockEntity entity) {
        return stockRepository.save(entity);
    }

    @Override
    public List<StockEntity> findAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public StockEntity findStockById(long id) {
        Optional<StockEntity> stockEntity = stockRepository.findById(id);
        return stockEntity.orElse(null);
    }

    @Override
    public void deleteStockById(long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<StockEntity> findByCriteria(Specification<StockEntity> spec, Pageable pageable) {
        return stockRepository.findAll(spec, pageable).getContent();
    }
}
