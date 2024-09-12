package ru.dc.ecom.example.orchestration.api.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockFilter {
    private long id;
    private String tag;
    private int amount;

}
