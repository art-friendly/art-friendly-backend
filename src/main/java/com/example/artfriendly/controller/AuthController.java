package com.example.artfriendly.controller;

import com.example.artfriendly.model.dto.OAuthTokenDto;
import com.example.artfriendly.service.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/oauth/kakao/login")
    public ResponseEntity<OAuthTokenDto> kakaoLogin(@RequestParam(name = "code") String code) throws JsonProcessingException {
        return ResponseEntity.ok(authService.kakoLogin(code));
    }


    @GetMapping("oauth/kakao/logout")
    public ResponseEntity<String> kakaoLogout(@RequestHeader(name = "Authorization") String token) throws JsonProcessingException {
        return ResponseEntity.ok(authService.kakoLogout(token)); // 로그아웃 아이디 반환됨
    }


    @GetMapping("oauth/kakao/unlink")
    public ResponseEntity<String> kakaoUnlink(@RequestHeader(name = "Authorization") String token)  {
        return ResponseEntity.ok(authService.kakaoUnlink(token)); // 로그아웃 아이디 반환됨
    }
}
