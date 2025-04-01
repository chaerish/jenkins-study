package com.example.skala.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MemberRequestDTO() {
    public record SignUpRequestDTO(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "영어와 숫자를 사용하여 4-12자의 아이디를 입력해주세요.")
            String loginId,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "영어와 숫자를 사용하여 8-20자의 비밀번호를 입력해주세요.")
            String password,
            @NotNull(message = "사용자의 이름을 꼭 입력해주세요.")
            String name,
            @NotNull(message = "현재 가지고 계신 요금을 입력해주세요.")
            Long price
    ) {
    }

    public record LoginRequestDTO(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String loginId,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password
    ) {
    }
    public record EditInfoRequestDTO(
            Long id,
            String name
    ) {
    }
}
