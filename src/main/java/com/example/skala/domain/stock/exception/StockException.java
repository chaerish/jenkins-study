package com.example.skala.domain.stock.exception;


import com.example.skala.global.exception.GeneralException;

public class StockException extends GeneralException {
    public StockException(StockErrorCode code) {
        super(code);
    }
}
