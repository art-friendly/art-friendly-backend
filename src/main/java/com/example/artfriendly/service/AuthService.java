package com.example.artfriendly.service;

import com.example.artfriendly.application.KakaoApi;
import com.example.artfriendly.model.dto.OAuthTokenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final KakaoApi kakaoApi;
    public OAuthTokenDto kakoLogin (String code) throws JsonProcessingException {
        return OAuthTokenDto.from(kakaoApi.login(code));
    }

    public String kakoLogout (String token) throws JsonProcessingException {
        return kakaoApi.logout(token);
    }

    public String kakaoUnlink(String token){
        return kakaoApi.unlink(token);
    }

}
