package com.example.skala.domain.member.service;

import com.example.skala.domain.member.dto.MemberRequestDTO;
import com.example.skala.domain.member.entity.Member;
import com.example.skala.domain.member.exception.MemberErrorCode;
import com.example.skala.domain.member.exception.MemberException;
import com.example.skala.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    @Override
    public Member signUp(MemberRequestDTO.SignUpRequestDTO dto) {
        if (memberRepository.existsByLoginId(dto.loginId())) {
            throw new MemberException(MemberErrorCode.DUPLICATE_LOGINID);
        }
        Member member = Member.builder().memberName(dto.name()).loginId(dto.loginId()).password(dto.password())
                .money(dto.price()).build();
        return memberRepository.save(member);
    }

    @Override
    public void login(MemberRequestDTO.LoginRequestDTO dto) {
        if (!memberRepository.existsByLoginId(dto.loginId())) {
            throw new MemberException(MemberErrorCode.INCORRECT_ID);
        }
        if (!memberRepository.existsByPassword(dto.password())) {
            throw new MemberException(MemberErrorCode.INVALID_TOKEN);
        }
        //jwt 토큰 발급 or 세션 or 쿠키 사용해서 인증,인가 처리
    }
    @Override
    @Transactional
    public Member edit(MemberRequestDTO.EditInfoRequestDTO dto) {
        Member member = memberRepository.findById(dto.id()).orElseThrow(
                ()-> new MemberException(MemberErrorCode.NOT_FOUND)
        );
        member.setMemberName(dto.name());
        check(dto.id());
        return member;
        //jwt 토큰 발급 or 세션 or 쿠키 사용해서 인증,인가 처리
    }
    @Transactional
    public void check(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new MemberException(MemberErrorCode.NOT_FOUND)
        );
        System.out.println(member.getMemberName());
    }
}
