package com.example.skala.domain.member.converter;

import com.example.skala.domain.member.dto.MemberResponseDTO;
import com.example.skala.domain.member.entity.Member;

public class MemberConverter {
    public static MemberResponseDTO.MemberInfoResponseDTO convert(Member member) {
        return new MemberResponseDTO.MemberInfoResponseDTO(member.getId(), member.getMemberName(), member.getMoney());
    }
}
