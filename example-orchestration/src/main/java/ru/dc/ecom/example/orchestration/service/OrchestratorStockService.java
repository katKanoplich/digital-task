package ru.dc.ecom.example.orchestration.service;

import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.orchestration.api.dto.StockDto;

import java.util.List;

public interface OrchestratorStockService {

    StockDto createStock(StockDto stockDto);

    StockDto updateStock(String stockId, StockDto stockDto);

    StockDto getStockById(String stockId);

    List<StockDto> getAllStocks();

    void deleteStock(String stockId);

    List<StockDto> getFilteredStocks(String tag, Pageable pageable);
}