package com.example.skala.global.exception;

import com.example.skala.global.apiPayload.code.base.BaseErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    private final BaseErrorCode baseErrorCode;

    public GeneralException(BaseErrorCode baseErrorCode) {
        this.baseErrorCode = baseErrorCode;
    }
}
