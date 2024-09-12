package ru.dc.ecom.example.orchestration.api.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.ecom.example.orchestration.api.controller.StockController;
import ru.dc.ecom.example.orchestration.api.dto.ProductDto;
import ru.dc.ecom.example.orchestration.api.dto.StockDto;
import ru.dc.ecom.example.orchestration.service.OrchestratorStockService;

import java.util.List;

@RestController
@Slf4j
public class StockControllerImpl implements StockController {

    private final OrchestratorStockService orchestratorService;

    public StockControllerImpl(OrchestratorStockService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @Override
    public StockDto createStock(StockDto stockDto) {
        log.debug("Event=CREATE_ROUTE, Msg='Start creating stock with data: {}'", stockDto);
        return orchestratorService.createStock(stockDto);
    }

    @Override
    public StockDto updateStock(String stockId, StockDto stockDto) {
        log.debug("Event=UPDATE_ROUTE, Msg='Start updating stock with ID: {}'", stockId);
        return orchestratorService.updateStock(stockId, stockDto);
    }

    @Override
    public StockDto getStockById(String stockId) {
        log.debug("Event=GET_ROUTE, Msg='Fetching stock with ID: {}'", stockId);
        return orchestratorService.getStockById(stockId);
    }

    @Override
    public List<StockDto> getAllStocks() {
        log.debug("Event=GET_ALL_ROUTE, Msg='Fetching all stocks'");
        return orchestratorService.getAllStocks();
    }

    @Override
    public void deleteStock(String stockId) {
        log.debug("Event=DELETE_ROUTE, Msg='Deleting stock with ID: {}'", stockId);
        orchestratorService.deleteStock(stockId);
    }

    @Override
    public List<StockDto> getFilteredStocks(String tag, Pageable pageable) {
        log.debug("Event=FILTER_ROUTE, Msg='Filtering products with Name: {}'", tag);
        return orchestratorService.getFilteredStocks(tag, pageable);
    }
}