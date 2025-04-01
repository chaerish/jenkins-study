package com.example.skala.domain.memberStock.service;

import com.example.skala.domain.memberStock.entity.MemberStock;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberStockQueryService {
    List<MemberStock> getMyStock(Long id);
}
