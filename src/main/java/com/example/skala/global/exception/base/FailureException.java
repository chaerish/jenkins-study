package com.example.skala.global.exception.base;


import com.example.skala.global.apiPayload.code.base.BaseErrorCode;
import com.example.skala.global.exception.GeneralException;

public class FailureException extends GeneralException {

    public FailureException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
