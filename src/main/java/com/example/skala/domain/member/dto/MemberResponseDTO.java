package com.example.skala.domain.member.dto;


import jakarta.validation.constraints.NotNull;

public record MemberResponseDTO() {
    public record MemberInfoResponseDTO(
            Long id,
            String name,
            Long price

    ) {
    }
}
