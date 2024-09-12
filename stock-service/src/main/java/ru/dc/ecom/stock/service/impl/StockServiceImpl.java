package ru.dc.ecom.stock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.dc.ecom.stock.api.dto.StockDto;
import ru.dc.ecom.stock.api.dto.filter.StockFilter;
import ru.dc.ecom.stock.converter.StockConverter;
import ru.dc.ecom.stock.model.StockEntity;
import ru.dc.ecom.stock.repository.StockRepositoryService;
import ru.dc.ecom.stock.repository.specification.StockSpecificationBuilder;
import ru.dc.ecom.stock.service.StockService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepositoryService stockRepository;


    private final StockConverter stockConverter;

    @Override
    public StockDto createStock(StockDto stockDto) {
        StockEntity stockEntity = stockConverter.convertToEntity(stockDto);
        StockEntity savedEntity = stockRepository.saveStock(stockEntity);
        return stockConverter.convertToDto(savedEntity);
    }

    @Override
    public StockDto getStockById(long id) {
        StockEntity stockEntity = stockRepository.findStockById(id);
        if (stockEntity != null) {
            return stockConverter.convertToDto(stockEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockRepository.findAllStocks().stream()
                .map(stockConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StockDto updateStock(long id, StockDto stockDto) {
        StockEntity stockEntity = stockRepository.findStockById(id);

        if (stockEntity == null) {
            throw new RuntimeException("Stock not found");
        }
        stockConverter.updateEntity(stockEntity, stockDto);
        StockEntity updatedEntity = stockRepository.saveStock(stockEntity);
        return stockConverter.convertToDto(updatedEntity);
    }

    @Override
    public void deleteStock(long id) {
        stockRepository.deleteStockById(id);
    }
    @Override
    public List<StockDto> getFilteredStocks(String tag, Pageable pageable) {
        StockFilter filter = new StockFilter();
        filter.setTag(tag);

        Specification<StockEntity> spec = StockSpecificationBuilder.buildStcokSpecification(filter);

        List<StockEntity> stockEntities = stockRepository.findByCriteria(spec, pageable);

        return stockEntities.stream()
                .map(stockConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
