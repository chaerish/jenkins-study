package com.example.skala.domain.member.service;

import com.example.skala.domain.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberQueryService {
    Member getMyInfoByLoginId(String loginId);

    Member getMyInfo(Long id);

}
