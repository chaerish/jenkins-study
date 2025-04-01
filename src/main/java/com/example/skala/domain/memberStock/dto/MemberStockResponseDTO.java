package com.example.skala.domain.memberStock.dto;

import java.util.List;

public record MemberStockResponseDTO() {
    public record AllMyStockDTO(
            List<EachMyStockDTO> eachStocks

    ) {
    }

    public record EachMyStockDTO(
            Long id,
            String stockName,
            Long price, // stock_price * quantity
            Long quantity
    ) {
    }
}
