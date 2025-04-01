package com.example.skala.domain.stock.dto;

import jakarta.validation.constraints.NotNull;

public record StockRequestDTO() {
    public record CreateStockRequestDTO(
            @NotNull
            String stockName,
            @NotNull
            Long price
    ) {
    }

    public record EditRequestDTO(
            String StockName,
            Long price
    ) {
    }
}
