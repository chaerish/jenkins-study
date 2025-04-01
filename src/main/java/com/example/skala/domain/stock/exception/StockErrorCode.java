package com.example.skala.domain.stock.exception;

import com.example.skala.global.apiPayload.code.base.BaseErrorCode;
import com.example.skala.global.apiPayload.dto.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StockErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "STOCK404", "해당 주식을 찾을 수 없습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .httpStatus(this.status)
                .isSuccess(false) // 에러이므로 항상 false
                .code(this.code)
                .message(this.message)
                .build();
    }
}
