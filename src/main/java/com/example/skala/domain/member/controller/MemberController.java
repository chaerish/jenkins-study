package com.example.skala.domain.member.controller;

import com.example.skala.domain.member.converter.MemberConverter;
import com.example.skala.domain.member.dto.MemberRequestDTO;
import com.example.skala.domain.member.service.MemberCommandService;
import com.example.skala.domain.member.service.MemberQueryService;
import com.example.skala.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @Operation(summary = "회원 가입", description = "사용자의 첫 회원가입을 진행합니다.")
    @PostMapping("/sign-up")
    public ApiResponse<?> signUp(@RequestBody @Valid MemberRequestDTO.SignUpRequestDTO dto) {
        return ApiResponse.onSuccess(MemberConverter.convert(memberCommandService.signUp(dto)));
    }

    @Operation(summary = "로그인", description = "아이디, 비밀번호를 가지고 로그인을 진행합니다.")
    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO dto) {
        memberCommandService.login(dto);
        return ApiResponse.onSuccess("로그인 되었습니다!");
    }

    @Operation(summary = "회원 정보 조회", description = "내 정보 조회를 수행합니다.")
    @GetMapping("/{id}/my-info")
    public ApiResponse<?> getMyInfo(@PathVariable Long id) {
        return ApiResponse.onSuccess(MemberConverter.convert(memberQueryService.getMyInfo(id)));
    }
    @Operation(summary = "회원 정보 수정", description = "내 정보 조회를 수행합니다.")
    @PatchMapping("/{id}/my-info")
    public ApiResponse<?> editsMyInfo(@PathVariable Long id, @RequestBody MemberRequestDTO.EditInfoRequestDTO dto) {
        return ApiResponse.onSuccess(MemberConverter.convert(memberCommandService.edit(dto)));
    }

}
