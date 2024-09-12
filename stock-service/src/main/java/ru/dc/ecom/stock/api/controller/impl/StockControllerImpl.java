package ru.dc.ecom.stock.api.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.ecom.stock.api.controller.StockController;
import ru.dc.ecom.stock.api.dto.StockDto;
import ru.dc.ecom.stock.service.StockService;

import java.util.List;

@RestController
@Slf4j
public class StockControllerImpl implements StockController {

    private final StockService stockService;

    public StockControllerImpl(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public StockDto updateStock(long stockId, StockDto stockDto) {
        log.debug("Event=UPDATE_ROUTE, Msg='Start updating stock with ID: {} and data: {}'", stockId, stockDto);
        StockDto updatedStock = stockService.updateStock(stockId, stockDto);
        log.debug("Event=UPDATE_Stock, Msg='Success in updating stock: {}'", updatedStock);
        return updatedStock;
    }

    @Override
    public StockDto createStock(StockDto stockDto) {
        log.debug("Event=CREATE_ROUTE, Msg='Start creating stock with data: {}'", stockDto);
        StockDto createdStock = stockService.createStock(stockDto);
        log.debug("Event=CREATE_stock, Msg='Success in creating stock: {}'", createdStock);
        return createdStock;
    }

    @Override
    public StockDto getStockById(long stockId) {
        log.debug("Event=GET_ROUTE, Msg='Fetching stock with ID: {}'", stockId);
        StockDto stock = stockService.getStockById(stockId);
        if (stock == null) {
            log.warn("Event=GET_stock, Msg='Stock not found for ID: {}'", stockId);
            throw new RuntimeException("Stock not found");
        }
        return stock;
    }

    @Override
    public List<StockDto> getAllStocks() {
        log.debug("Event=GET_ALL_ROUTE, Msg='Fetching all stocks'");
        return stockService.getAllStocks();
    }

    @Override
    public void deleteStock(long stockId) {
        log.debug("Event=DELETE_ROUTE, Msg='Deleting stock with ID: {}'", stockId);
        stockService.deleteStock(stockId);
        log.debug("Event=DELETE_stock, Msg='Successfully deleted stock with ID: {}'", stockId);
    }

    @Override
    public List<StockDto> getFilteredStocks(String tag, Pageable pageable) {
        log.debug("Event=FILTER_ROUTE, Msg='Filtering stocks with Name: {} on page: {}'", tag, pageable.getPageNumber());
        List<StockDto> filteredStocks = stockService.getFilteredStocks(tag, pageable);
        log.debug("Event=FILTER_stocks, Msg='Filtered stocks count: {}'", filteredStocks.size());
        return filteredStocks;
    }
}