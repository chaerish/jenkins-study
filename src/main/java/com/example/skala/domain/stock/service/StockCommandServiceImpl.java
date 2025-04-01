package com.example.skala.domain.stock.service;

import com.example.skala.domain.stock.dto.StockRequestDTO;
import com.example.skala.domain.stock.dto.StockRequestDTO.EditRequestDTO;
import com.example.skala.domain.stock.entity.Stock;
import com.example.skala.domain.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class StockCommandServiceImpl implements StockCommandService {
    private final StockRepository stockRepository;

    @Override
    public Long createNewStock(StockRequestDTO.CreateStockRequestDTO dto) {
        Stock stock = Stock.builder()
                .stockName(dto.stockName())
                .price(dto.price())
                .build();
        return stockRepository.save(stock).getId();
    }

    @Override
    @Transactional
    public Stock editStock(Stock stock, EditRequestDTO dto) {
        if (dto.price() != null) {
            stock.changePrice(dto.price());
        }
        if (dto.StockName() != null) {
            stock.changeStockName(dto.StockName());
        }
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Stock stock) {
        stockRepository.delete(stock);
    }
}
