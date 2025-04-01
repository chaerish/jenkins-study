package com.example.skala.domain.stock.service;

import com.example.skala.domain.stock.entity.Stock;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface StockQueryService {
    Stock getStockByName(String name);

    List<Stock> getAllStock();

    Stock getEachStock(Long id);

}
