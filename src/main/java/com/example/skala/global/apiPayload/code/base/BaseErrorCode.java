package com.example.skala.global.apiPayload.code.base;

import com.example.skala.global.apiPayload.dto.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReasonHttpStatus();
}