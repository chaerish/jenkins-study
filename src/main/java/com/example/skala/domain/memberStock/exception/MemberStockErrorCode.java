package com.example.skala.domain.memberStock.exception;

import com.example.skala.global.apiPayload.code.base.BaseErrorCode;
import com.example.skala.global.apiPayload.dto.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberStockErrorCode implements BaseErrorCode {
    UNABLE_PURCHASE(HttpStatus.NOT_FOUND, "MEMBER400", "잔고가 부족해 해당 주식을 구매할 수 없습니다.");
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
