package com.example.skala.domain.member.service;

import com.example.skala.domain.member.entity.Member;
import com.example.skala.domain.member.exception.MemberErrorCode;
import com.example.skala.domain.member.exception.MemberException;
import com.example.skala.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public Member getMyInfoByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId).orElseThrow(
                () -> new MemberException(MemberErrorCode.NOT_FOUND)
        );
    }

    @Override
    public Member getMyInfo(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new MemberException(MemberErrorCode.NOT_FOUND)
        );
    }

}
