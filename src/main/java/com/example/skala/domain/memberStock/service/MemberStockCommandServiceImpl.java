package com.example.skala.domain.memberStock.service;

import com.example.skala.domain.member.entity.Member;
import com.example.skala.domain.member.repository.MemberRepository;
import com.example.skala.domain.memberStock.dto.MemberStockRequestDTO.BuyStockRequestDTO;
import com.example.skala.domain.memberStock.entity.MemberStock;
import com.example.skala.domain.memberStock.exception.MemberStockErrorCode;
import com.example.skala.domain.memberStock.exception.MemberStockException;
import com.example.skala.domain.memberStock.repository.MemberStockRepository;
import com.example.skala.domain.stock.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberStockCommandServiceImpl implements MemberStockCommandService {
    private final MemberStockRepository memberStockRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void buyStock(Stock stock, Member member, BuyStockRequestDTO dto) {
        Long stockPrice = stock.getPrice() * dto.quantity();
        if (!member.canBuyIt(stockPrice)) {
            throw new MemberStockException(MemberStockErrorCode.UNABLE_PURCHASE);
        }
        member.useMoney(stockPrice);
        memberRepository.save(member);
        MemberStock memberStock = MemberStock.builder()
                .stock(stock)
                .member(member)
                .quantity(dto.quantity())
                .build();
        memberStockRepository.save(memberStock);
    }
}
