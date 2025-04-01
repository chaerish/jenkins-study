package com.example.skala.domain.stock.dto;

import java.util.List;

public record StockResponseDTO() {
    public record AllStockDTO(
            List<EachStockDTO> eachStocks

    ) {
    }

    public record EachStockDTO(
            Long id,
            String stockName,
            Long price

    ) {
    }
}
