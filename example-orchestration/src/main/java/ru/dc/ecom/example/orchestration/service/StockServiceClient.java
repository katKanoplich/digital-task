package ru.dc.ecom.example.orchestration.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.dc.ecom.example.orchestration.api.dto.StockDto;

import java.util.List;

@FeignClient(name = "stockService", url = "${stock.service.url}")
public interface StockServiceClient {

    @PostMapping("/stocks")
    StockDto createStock(StockDto stockDto);

    @PutMapping("/stocks/{stockId}")
    StockDto updateStock(@PathVariable("stockId") String stockId, @RequestBody StockDto stockDto);

    @GetMapping("/stocks/{stockId}")
    StockDto getStockById(@PathVariable("stockId") String stockId);

    @GetMapping("/stocks")
    List<StockDto> getAllStocks();

    @DeleteMapping("/stocks/{stockId}")
    void deleteStock(@PathVariable("stockId") String stockId);

    @GetMapping("/stocks/filter")
    List<StockDto> getFilteredStocks(@RequestParam("tag") String tag,
                                     @RequestParam("page") int page,
                                     @RequestParam("size") int size);
}