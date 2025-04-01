package com.example.skala.domain.memberStock.exception;


import com.example.skala.global.exception.GeneralException;

public class MemberStockException extends GeneralException {
    public MemberStockException(MemberStockErrorCode code) {
        super(code);
    }
}
