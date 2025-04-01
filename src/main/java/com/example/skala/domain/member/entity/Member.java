package com.example.skala.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_name", nullable = false)
    private String memberName;
    @Column(name = "money", nullable = false)
    private Long money;
    @Column(name = "loginId", nullable = false)
    private String loginId;
    @Column(name = "password", nullable = false)
    private String password;

    public boolean canBuyIt(Long price) {
        return this.money >= price;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void useMoney(Long price) {
        this.money = money - price;
    }
}
