package com.example.skala.domain.member.service;

import com.example.skala.domain.member.dto.MemberRequestDTO;
import com.example.skala.domain.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberCommandService {
    Member signUp(MemberRequestDTO.SignUpRequestDTO dto);

    void login(MemberRequestDTO.LoginRequestDTO dto);
    Member edit(MemberRequestDTO.EditInfoRequestDTO dto);
    void check(Long id);
}
