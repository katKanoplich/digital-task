package ru.dc.ecom.example.orchestration.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import ru.dc.ecom.example.orchestration.api.dto.StockDto;
import ru.dc.ecom.example.orchestration.service.OrchestratorStockService;
import ru.dc.ecom.example.orchestration.service.StockServiceClient;

import java.util.List;

@Service
@Slf4j
public class OrchestratorStockServiceImpl implements OrchestratorStockService {

    private final StockServiceClient stockServiceClient;

    @Autowired
    public OrchestratorStockServiceImpl(StockServiceClient stockServiceClient) {
        this.stockServiceClient = stockServiceClient;
    }

    @Override
    public StockDto createStock(StockDto stockDto) {
        log.debug("Orchestrator: Creating stock");
        return stockServiceClient.createStock(stockDto);
    }

    @Override
    public StockDto updateStock(String stockId, StockDto stockDto) {
        log.debug("Orchestrator: Updating stock with ID: {}", stockId);
        return stockServiceClient.updateStock(stockId, stockDto);
    }

    @Override
    public StockDto getStockById(String stockId) {
        log.debug("Orchestrator: Fetching stock with ID: {}", stockId);
        return stockServiceClient.getStockById(stockId);
    }

    @Override
    public List<StockDto> getAllStocks() {
        log.debug("Orchestrator: Fetching all stocks");
        return stockServiceClient.getAllStocks();
    }

    @Override
    public void deleteStock(String stockId) {
        log.debug("Orchestrator: Deleting stock with ID: {}", stockId);
        stockServiceClient.deleteStock(stockId);
    }

    @Override
    public List<StockDto> getFilteredStocks(String tag, Pageable pageable) {
        log.debug("Orchestrator: Filtering stocks with Name: {}", tag);
        return stockServiceClient.getFilteredStocks(tag, pageable.getPageNumber(), pageable.getPageSize());
    }
}