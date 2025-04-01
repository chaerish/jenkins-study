package com.example.skala.domain.memberStock.controller;

import com.example.skala.domain.member.entity.Member;
import com.example.skala.domain.member.service.MemberQueryService;
import com.example.skala.domain.memberStock.converter.MemberStockConverter;
import com.example.skala.domain.memberStock.dto.MemberStockRequestDTO;
import com.example.skala.domain.memberStock.service.MemberStockCommandService;
import com.example.skala.domain.memberStock.service.MemberStockQueryService;
import com.example.skala.domain.stock.entity.Stock;
import com.example.skala.domain.stock.service.StockQueryService;
import com.example.skala.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member-stock")
public class MemberStockController {
    private final MemberStockCommandService memberStockCommandService;
    private final MemberStockQueryService memberStockQueryService;
    private final StockQueryService stockQueryService;
    private final MemberQueryService memberQueryService;

    /*
    1. 가지고 있는 stock 조회
    2. stock 구매(post) -> 이때 내가 가지고 있는 돈이 깎임.
        - 자신의 요금보다 더 비싼 것은 살 수 없음. (에러 리턴)
    3. 주식 삭제
     */
    @GetMapping("/{memberId}")
    @Operation(summary = "가지고 있는 주식 조회", description = "내가 가진 주식을 조회합니다. ")
    public ApiResponse<?> getMyStock(@PathVariable Long memberId) {
        return ApiResponse.onSuccess(MemberStockConverter.convert(memberStockQueryService.getMyStock(memberId)));
    }


    @Operation(summary = "주식 사기", description = "주식을 구매합니다.")
    @Parameters()
    @PostMapping("/buy")
    public ApiResponse<?> buyStock(@RequestBody @Valid MemberStockRequestDTO.BuyStockRequestDTO dto) {
        Stock stock = stockQueryService.getStockByName(dto.stockName());
        Member member = memberQueryService.getMyInfoByLoginId(dto.loginId());
        memberStockCommandService.buyStock(stock, member, dto);
        return ApiResponse.onSuccess("구매가 완료되었습니다.");
    }


}
