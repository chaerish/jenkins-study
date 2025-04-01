package com.example.skala.domain.memberStock.repository;

import com.example.skala.domain.memberStock.entity.MemberStock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberStockRepository extends JpaRepository<MemberStock, Long> {
    List<MemberStock> findAllByMemberId(Long memberId);
}
