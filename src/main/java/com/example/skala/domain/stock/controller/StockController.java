package com.example.skala.domain.stock.controller;

import com.example.skala.domain.stock.converter.StockConverter;
import com.example.skala.domain.stock.dto.StockRequestDTO;
import com.example.skala.domain.stock.entity.Stock;
import com.example.skala.domain.stock.service.StockCommandService;
import com.example.skala.domain.stock.service.StockQueryService;
import com.example.skala.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock")
public class StockController {
    private final StockCommandService stockCommandService;
    private final StockQueryService stockQueryService;

    @PostMapping("/create")
    @Operation(summary = "새로운 주식 등록", description = "새로운 주식을 등록한다.")
    //새로운 stock 등록
    public ApiResponse<?> createNewStock(@RequestBody @Valid StockRequestDTO.CreateStockRequestDTO dto) {
        return ApiResponse.onSuccess(stockCommandService.createNewStock(dto) + "아이디의 새로운 stock 이 생성 되었습니다.");
    }

    @GetMapping("/all")
    @Operation(summary = "모든 주식 조회", description = "현재 등록된 주식을 모두 조회합니다.")
    //stock 전체 조회
    public ApiResponse<?> getAllStock() {
        return ApiResponse.onSuccess(StockConverter.convert(stockQueryService.getAllStock()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "특정 주식의 정보 조회", description = "주식 아이디를 가지고 특정 주식의 정보를 상세 조회합니다.")
    public ApiResponse<?> getEachStock(@PathVariable Long id) {
        return ApiResponse.onSuccess(StockConverter.convert(stockQueryService.getEachStock(id)));
    }

    //stock 정보수정
    @PatchMapping("/{id}/edit")
    @Operation(summary = "주식 정보를 수정합니다.", description = "주식이름이나 가격을 수정합니다.")
    public ApiResponse<?> editStock(@PathVariable Long id, @RequestBody StockRequestDTO.EditRequestDTO dto) {
        Stock stock = stockQueryService.getEachStock(id);
        return ApiResponse.onSuccess(StockConverter.convert(stockCommandService.editStock(stock, dto)));
    }

    //stock 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "주식 삭제", description = "주식을 삭제합니다.")
    public ApiResponse<?> deleteStock(@PathVariable Long id) {
        stockCommandService.deleteStock(stockQueryService.getEachStock(id));
        return ApiResponse.onSuccess("삭제되었습니다.");
    }
}
