package ru.dc.ecom.stock.service;

import org.springframework.data.domain.Pageable;
import ru.dc.ecom.stock.api.dto.StockDto;

import java.util.List;

public interface StockService {
    StockDto createStock(StockDto stockDto);

    StockDto getStockById(long id);

    List<StockDto> getAllStocks();

    StockDto updateStock(long id, StockDto stockDto);

    void deleteStock(long id);

    List<StockDto> getFilteredStocks(String tag, Pageable pageable);
}
