package com.example.skala.domain.member.exception;


import com.example.skala.global.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(MemberErrorCode code) {
        super(code);
    }
}
