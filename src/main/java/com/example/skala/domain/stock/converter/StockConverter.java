package com.example.skala.domain.stock.converter;

import com.example.skala.domain.stock.dto.StockResponseDTO;
import com.example.skala.domain.stock.entity.Stock;
import java.util.List;

public class StockConverter {
    public static StockResponseDTO.EachStockDTO convert(Stock stock) {
        return new StockResponseDTO.EachStockDTO(stock.getId(), stock.getStockName(), stock.getPrice());
    }

    public static StockResponseDTO.AllStockDTO convert(List<Stock> stocks) {
        List<StockResponseDTO.EachStockDTO> eachStocks = stocks.stream()
                .map(StockConverter::convert).toList();
        return new StockResponseDTO.AllStockDTO(eachStocks);
    }
}
