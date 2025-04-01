package com.example.skala.domain.stock.service;

import com.example.skala.domain.stock.entity.Stock;
import com.example.skala.domain.stock.exception.StockErrorCode;
import com.example.skala.domain.stock.exception.StockException;
import com.example.skala.domain.stock.repository.StockRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockQueryServiceImpl implements StockQueryService {
    private final StockRepository stockRepository;

    @Override
    public Stock getStockByName(String name) {
        return stockRepository.findByStockName(name).orElseThrow(
                () -> new StockException(StockErrorCode.NOT_FOUND)
        );
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getEachStock(Long id) {
        return stockRepository.findById(id).orElseThrow(
                () -> new StockException(StockErrorCode.NOT_FOUND)
        );
    }
}
