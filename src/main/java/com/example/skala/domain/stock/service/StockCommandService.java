package com.example.skala.domain.stock.service;

import com.example.skala.domain.stock.dto.StockRequestDTO;
import com.example.skala.domain.stock.entity.Stock;
import org.springframework.stereotype.Service;

@Service
public interface StockCommandService {
    Long createNewStock(StockRequestDTO.CreateStockRequestDTO dto);

    Stock editStock(Stock stock, StockRequestDTO.EditRequestDTO dto);

    void deleteStock(Stock stock);
}
