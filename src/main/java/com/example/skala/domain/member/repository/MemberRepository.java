package com.example.skala.domain.member.repository;

import com.example.skala.domain.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByLoginId(String loginId);

    boolean existsByPassword(@Param("password") String password);

    Optional<Member> findByLoginId(String loginId);
}
