package com.example.skala.domain.memberStock.service;

import com.example.skala.domain.member.entity.Member;
import com.example.skala.domain.memberStock.dto.MemberStockRequestDTO;
import com.example.skala.domain.stock.entity.Stock;
import org.springframework.stereotype.Service;

@Service
public interface MemberStockCommandService {
    void buyStock(Stock stock, Member member, MemberStockRequestDTO.BuyStockRequestDTO dto);
}
