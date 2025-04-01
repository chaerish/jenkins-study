package com.example.skala.domain.memberStock.service;

import com.example.skala.domain.memberStock.entity.MemberStock;
import com.example.skala.domain.memberStock.repository.MemberStockRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberStockStockQueryServiceImpl implements MemberStockQueryService {
    private final MemberStockRepository memberStockRepository;

    @Override
    public List<MemberStock> getMyStock(Long id) {
        return memberStockRepository.findAllByMemberId(id);
    }
}
