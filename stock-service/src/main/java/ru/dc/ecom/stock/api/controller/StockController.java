package ru.dc.ecom.stock.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dc.ecom.stock.api.dto.StockDto;

import java.util.List;

@Tag(name = "Stock", description = "Stock API")
@RequestMapping("/v1/stocks")
public interface StockController {

    @PutMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a Stock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    StockDto updateStock(
            @Parameter(description = "Id of a Stock. Cannot be empty.", required = true)
            @PathVariable("stockId") long stockId,
            @Validated @RequestBody StockDto stock);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Stock")
    @ResponseStatus(HttpStatus.CREATED)
    StockDto createStock(
            @Validated @RequestBody StockDto stock);

    @GetMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a Stock by ID")
    @ResponseStatus(HttpStatus.OK)
    StockDto getStockById(
            @Parameter(description = "Id of a Stock. Cannot be empty.", required = true)
            @PathVariable("stockId") long stockId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all Stocks")
    @ResponseStatus(HttpStatus.OK)
    List<StockDto> getAllStocks();

    @DeleteMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a Stock by ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStock(
            @Parameter(description = "Id of a Stock. Cannot be empty.", required = true)
            @PathVariable("stockId") long stockId);

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get filtered Stocks by name and pageable")
    @ResponseStatus(HttpStatus.OK)
    List<StockDto> getFilteredStocks(
            @Parameter(description = "Name of the Stock to filter by", required = true)
            @RequestParam String tag,
            @Parameter(description = "Pagination information", required = true)
            Pageable pageable);
}