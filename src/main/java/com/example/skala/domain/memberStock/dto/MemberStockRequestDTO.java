package com.example.skala.domain.memberStock.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record MemberStockRequestDTO() {
    public record BuyStockRequestDTO(
            @NotNull(message = "사용자 아이디를 입력해주세요.")
            @Schema(description = "사용자 로그인 ID", example = "user123")
            String loginId,

            @NotNull(message = "주식 이름은 필수값입니다.")
            @Schema(description = "구매할 주식 이름", example = "삼성전자")
            String stockName,

            @NotNull(message = "구매하실 수량을 입력하세요.")
            @Schema(description = "구매 수량", example = "10")
            Long quantity

    ) {
    }
}
